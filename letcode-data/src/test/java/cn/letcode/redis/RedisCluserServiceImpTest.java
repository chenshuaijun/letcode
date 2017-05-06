package cn.letcode.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chenshuaijun on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-data-redis.xml")
public class RedisCluserServiceImpTest {

	@Autowired
	public RedisTemplate<?, ?>		redisTemplate;

	private RedisCluserServiceImp	redisCluserServiceImp;

	@Before
	public void before() {
		redisCluserServiceImp = new RedisCluserServiceImp();
		redisCluserServiceImp.setRedisTemplate(redisTemplate);
	}

	@Test
	public void test() {
		// ValueOperations vo = redisTemplate.opsForValue();
		// for (int i = 1; i < 1000; i++) {
		// vo.set("key:" + i, "tt" + StringUtils.leftPad(i + "", 5, "0"));
		// }
		// for (int i = 1; i < 1000; i++) {
		// Object obj = vo.get("key:" + i);
		// System.out.println(obj + ":::: seq:::" + vo.increment("seq", 1));
		// }
		for (int i = 1; i <= 10000; i++)
			System.out.println(redisCluserServiceImp.getRedisSquence("REDIS_SEQ"));
	}
}
