package example.springdata.redis.hash;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 项目名称：
 * 类名称：BeanUtilsHashMapperTest
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 11:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanUtilsHashMapperTest {

    BeanUtilsHashMapper hashMapper = new BeanUtilsHashMapper(Person.class);

    @Test
    public void toHash() {
        Map<String, Object> map = hashMapper.toHash(new Person("name", 123, 1));
        // {sex=0, name=name, class=class example.springdata.redis.hash.Person, age=123}
        System.out.println(map);

        map.remove("class");
        // {sex=0, name=name, age=123}
        System.out.println(map);
    }

    @Test
    public void fromHash() {
        Map<String, Object> hash = new HashMap<String, Object>();
        hash.put("name", "name");
        // Person{name='name', age=null, sex=0, map=null}
        System.out.println(hashMapper.fromHash(hash));

        hash.put("class", "example.springdata.redis.hash.Person");
        // Person{name='name', age=null, sex=0, map=null}
        System.out.println(hashMapper.fromHash(hash));
    }

}
