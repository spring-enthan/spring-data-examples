package example.springdata.redis.operation;

import cn.hutool.core.map.MapUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/**
 * 项目名称：
 * 类名称：BoundHashOperationsTest
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 12:13
 */
public class BoundHashOperationsTest extends BaseOperations {

    @Test
    public void testPut() {
        redisTemplate.boundHashOps("key").put("1", "value");

        System.out.println(redisTemplate.boundHashOps("key").get("1"));
        System.out.println(redisTemplate.boundHashOps("key").entries());
    }

    @Test
    public void testGet() {
        System.out.println(redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).get("@class"));
    }

    @Test
    public void testKeys() {
        Set set = redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).keys();
        set.forEach(System.out::println);
    }

    @Test
    public void testValues() {
        List list = redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).values();
        list.forEach(System.out::println);
    }

    @Test
    public void testEntries() {
        Map map = redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).entries();
        map.entrySet().stream().forEach(entry -> {
            Map.Entry KV = (Map.Entry) entry;
            System.out.println(KV.getKey() + " = " + KV.getValue());
        });
    }

    @Test
    public void testPutAll() {
        Map map = redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).entries();
        map.entrySet().stream().forEach(entry -> {
            Map.Entry KV = (Map.Entry) entry;
            System.out.println(KV.getKey() + " = " + KV.getValue());
        });

        map.put("mute", false);
        redisTemplate.boundHashOps(key("confInfoPexip", "1000254527")).putAll(map);
    }

    @Test
    public void testPutAllMap() {
        Map map = MapUtil.builder(new HashMap<String, Object>())
            .put("@class", "com.m2c.bms.data.UserInfo")
            .put("userId", 999)
            .put("outPartyId", "127A")
            .build();

        map.put("mute", false);
        redisTemplate.boundHashOps(key("userInfo", "999")).putAll(map);
    }

}
