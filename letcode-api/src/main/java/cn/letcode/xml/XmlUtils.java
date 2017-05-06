package cn.letcode.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by chenshuaijun on 2017/4/21. XML报文处理工具
 */
public class XmlUtils {
	/**
	 * 初始化处理实例,使用静态方法提高使用效率
	 */
	public static XStream xstream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));

	/**
	 * 将实体bean转成XML字符串
	 *
	 * @param object
	 *            bean对象
	 * @return xmlstring
	 */
	public static String beanToString(Object object) {
		xstream.autodetectAnnotations(true);
		// 设置处理过程中，忽略未知的元素
		xstream.ignoreUnknownElements();
		return formatXMLInOneLine(appendHeadXml(xstream.toXML(object)));
	}

	/**
	 * 将xml字符串 转成bean
	 *
	 * @param xmlStr
	 *            xml字符串
	 * @param bean
	 *            需要转换的对象实例
	 * @param rootName
	 *            xml元素root跟名称
	 * @return bean对象
	 * @author chenshuaijun
	 */
	public static Object xmlStrToBean(String xmlStr, Class<?> bean, String rootName) {
		xstream.autodetectAnnotations(true);
		// 设置处理过程中，忽略未知的元素
		xstream.ignoreUnknownElements();
		xstream.alias(rootName, bean);
		return xstream.fromXML(xmlStr);
	}

	/**
	 * 美化xml内容，格式化
	 *
	 * @param inputXML
	 *            输入需要格式化的xml字符串
	 * @return 返回格式化后的内容
	 * @throws Exception
	 *             处理异常
	 * @author chenshuaijun
	 */
	public static String formatXML(String inputXML) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new StringReader(inputXML));
		String retXML = null;
		XMLWriter writer = null;
		if (document != null) {
			try {
				StringWriter stringWriter = new StringWriter();
				OutputFormat format = new OutputFormat(" ", true);
				writer = new XMLWriter(stringWriter, format);
				writer.write(document);
				writer.flush();
				retXML = stringWriter.getBuffer().toString();
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return retXML;
	}

	/**
	 * 将xml转换成功一行
	 *
	 * @param inputXML
	 *            输入xml内容
	 * @return 格式化后的内容
	 * @author chenshuaijun
	 */
	public static String formatXMLInOneLine(String inputXML) {
		String retXml = "";
		XMLWriter writer = null;
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(new StringReader(inputXML));
			if (document != null) {
				StringWriter stringWriter = new StringWriter();
				OutputFormat format = new OutputFormat("", false);
				format.setTrimText(true);
				format.setNewLineAfterDeclaration(false);
				writer = new XMLWriter(stringWriter, format);
				writer.write(document);
				writer.flush();
				retXml = stringWriter.getBuffer().toString();
			}
		} catch (IOException | DocumentException e) {
			return "";
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}

		return retXml;
	}

	/**
	 * 拼接xml报文头部分<br>
	 * 默认编码 UTF-8
	 *
	 * @param xml
	 *            头部分内容
	 * @return 添加xml头后的字符串
	 */
	public static String appendHeadXml(String xml) {
		return appendHeadXml(xml, "utf-8");
	}

	/**
	 * 拼接xml报文头部分
	 *
	 * @param xml
	 *            XML字符串
	 * @param charset
	 *            指定编码集
	 * @return 返回添加后的字符串
	 */
	public static String appendHeadXml(String xml, String charset) {
		return "<?xml version=\"1.0\" encoding=\"" + charset + "\"?>\n" + (xml == null ? "" : xml);
	}
}
