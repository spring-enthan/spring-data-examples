package example.springdata.redis.operation;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisShardInfo;

/**
 * 项目名称：
 * 类名称：BaseOperations
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 15:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseOperations {

    protected RedisTemplate redisTemplate = new RedisTemplate();

    RedisSerializer stringRedisSerializer = new StringRedisSerializer();
    RedisSerializer jacksonRedisSerializer = new GenericJackson2JsonRedisSerializer();

    @Before
    public void setUp() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo("172.24.4.141", 6379);
        jedisShardInfo.setPassword("123456");
        redisTemplate.setConnectionFactory(new JedisConnectionFactory(jedisShardInfo));
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jacksonRedisSerializer);
        redisTemplate.setHashValueSerializer(jacksonRedisSerializer);
        redisTemplate.afterPropertiesSet();
    }

    public String key(String... keys) {
        keys = ArrayUtil.insert(keys, 0, "plat");
        String key = StrUtil.join(":", keys);

        System.out.println("key = " + key);
        return key;
    }

}
