package cn.letcode.redis;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Redis数据处理工具类
 * 
 * @author chenshuaijun
 *
 */
public class RedisUtils {
	public static Logger	logger			= LoggerFactory.getLogger(RedisUtils.class);
	public static String	defaultPadStr	= "0";

	/**
	 * 得到序列左边补0，执行补充的长度
	 * 
	 * @param seq
	 *            序列值
	 * @param length
	 *            序列长度
	 * @return 补充后的字符串
	 * @author chenshuaijun
	 */
	public static String lpadSquenceValue(String seq, int length) {
		if (StringUtils.isBlank(seq)) {
			logger.warn("recv from redis's seq is blank :[{}],and return default '0' ", seq);
			seq = "0";
		}
		return StringUtils.leftPad(seq, length, defaultPadStr);
	}
}
