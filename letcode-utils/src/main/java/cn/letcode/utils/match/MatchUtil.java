package cn.letcode.utils.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配工具
 * 
 * @author 帅军
 *
 */
public class MatchUtil {
	public static final Pattern patternParam = Pattern.compile("[$]\\{([\\w]+)\\}");

	/**
	 * <b>根据$ 匹配 $+{+参数名称+} ;</b><br>
	 * 根据参数名称获取参数 params中的值<br>
	 * <i>此功能可用作模板填充中</i>
	 * 
	 * @param s
	 *            元数据
	 * @param params
	 *            参数Map
	 * @return StringBuilder
	 */
	public static String matchplaceValue(String s, Map<?, ?> params) {
		for (Matcher matcher = patternParam.matcher(s); matcher.find();) {
			int sub = matcher.groupCount();
			String n = matcher.group(sub).trim();
			String val = String.valueOf(params.get(matcher.group(sub).trim()));
			s = s.replace("${" + n + "}", val);
		}
		return s;
	}

	/**
	 * 获取指定HTML标签的指定属性的值
	 * 
	 * @param source
	 *            要匹配的源文本
	 * @param element
	 *            标签名称
	 * @param attr
	 *            标签的属性名称
	 * @return 属性值列表
	 */
	public static List<String> listMatchHtmlAttrValue(String source, String element, String attr) {
		List<String> result = new ArrayList<String>();
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?\\s.*?>";
		Matcher m = Pattern.compile(reg).matcher(source);
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;
	}

	/**
	 * 获取指定HTML标签的指定属性的值
	 * 
	 * @param source
	 *            要匹配的源文本
	 * @param element
	 *            标签名称
	 * @param attr
	 *            标签的属性名称
	 * @return 属性值
	 */
	public static String singleMatchHtmlAttrValue(String source, String element, String attr) {
		String reg = "<" + element + "[^<>]*?\\s" + attr + "=['\"]?(.*?)['\"]?\\s.*?>";
		Matcher m = Pattern.compile(reg).matcher(source);
		if (m.find()) {
			return m.group(1);
		}
		return "";
	}

	/**
	 * 获取指定属性值得HTML标签的text内容
	 * 
	 * @param source
	 *            要匹配的源文本
	 * @param element
	 *            标签名称
	 * @param attr
	 *            标签的属性名称
	 * @param attrVal
	 *            指定的属性值
	 * @return 属性值
	 */
	public static String singleMatchHtmlValue(String source, String element, String attr, String attrVal) {
		String reg = "<" + element + "([\\s+]|[\\w\\W][^>]+)" + attr;
		reg += "=\"" + attrVal + "\">?([\\w\\W\\s\\S][^<]*)</" + element + ">";
		System.out.println(reg);
		System.out.println(source);
		Matcher m = Pattern.compile(reg).matcher(source);
		if (m.find()) {
			return m.group(m.groupCount());
		}
		return "";
	}

	/**
	 * 获取指定属性值得HTML标签的text内容
	 * 
	 * @param source
	 *            要匹配的源文本
	 * @param element
	 *            标签名称
	 * @param attr
	 *            标签的属性名称
	 * @param attrVal
	 *            指定的属性值
	 * @return 属性值
	 */
	public static List<String> listMatchHtmlValue(String source, String element, String attr, String attrVal) {
		String reg = "<" + element + "([\\s+]|[\\w\\W][^>]+)" + attr;
		reg += "=\"" + attrVal + "\">?([\\w\\W\\s\\S][^<]*)</" + element + ">";
		Matcher m = Pattern.compile(reg).matcher(source);
		List<String> list = new ArrayList<String>();
		while (m.find()) {
			list.add(m.group(m.groupCount()));
		}
		return list;
	}
}
