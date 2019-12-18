package example.springdata.redis.hash;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 项目名称：
 * 类名称：HashMapperTest
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 11:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonHashMapperTest {

    Jackson2HashMapper hashMapper = new Jackson2HashMapper(false);

    @Test
    public void toHash() {
        Map<String, Object> map = hashMapper.toHash(new Person("name", 123, 1));
        // {@class=example.springdata.redis.hash.Person, name=name, age=123, sex=0}
        System.out.println(map);
        map.remove("class");
        System.out.println(map);
    }

    @Test
    public void fromHash() {
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("@class", "example.springdata.redis.hash.Person");
        hash.put("name", "name");
        System.out.println(hashMapper.fromHash(hash));
    }

}
