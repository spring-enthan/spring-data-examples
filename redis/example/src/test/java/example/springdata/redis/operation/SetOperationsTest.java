package example.springdata.redis.operation;

import java.util.Set;
import org.junit.Test;

/**
 * 项目名称：
 * 类名称：SetOperationsTest
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 15:42
 */
public class SetOperationsTest extends BaseOperations {

    @Test
    public void testMembers() {
        // key = plat:confInfo:userIds[]:1439108, userIds[]字面定义,表示为数组
        Set set = redisTemplate.opsForSet().members(key("confInfo", "userIds[]", "1439108"));
        set.forEach(System.out::println);
    }



}
