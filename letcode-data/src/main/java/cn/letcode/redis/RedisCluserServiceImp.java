package cn.letcode.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by chenshuaijun on 2017/4/22. <br>
 * redis集群配置
 *
 * @author chenshuaijun
 */
public class RedisCluserServiceImp {
	protected int					defaultLength		= 6;
	protected Long					defaultIncreaseNo	= 1L;
	/**
	 * Redis 链接对象
	 */
	protected RedisTemplate<?, ?>	redisTemplate;

	/**
	 * 根据定义的序列的名字 获取序列号，定一个序列长度，返回一个固定的长度值 <br>
	 * 传入值为：getRedisSquence("seq",6);获取到的值是 3 --> 000006
	 * 
	 * @param squName
	 *            自定义序列名称
	 * @param length
	 *            序列自动补充长度
	 * @return 拼接处理后的值
	 */
	public String getRedisSquence(String squName, int length) {
		@SuppressWarnings("unchecked")
		ValueOperations<String, Long> vo = (ValueOperations<String, Long>) redisTemplate.opsForValue();
		Long val = vo.increment(squName, defaultIncreaseNo);
		return RedisUtils.lpadSquenceValue(String.valueOf(val), defaultLength);
	}

	/**
	 * 根据定义的序列的名字 获取序列号，定一个序列长度，返回一个固定的长度值 <br>
	 * 默认序列长度为 6 <br>
	 * 传入值为：getRedisSquence("seq",6);获取到的值是 3 --> 000006
	 * 
	 * @param squName
	 *            自定义序列名称
	 * @return 拼接处理后的值
	 */
	public String getRedisSquence(String squName) {
		return getRedisSquence(squName, defaultLength);
	}

	public RedisTemplate<?, ?> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<?, ?> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
