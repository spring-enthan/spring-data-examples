package example.springdata.redis.hash;

import java.util.Map;

/**
 * 项目名称：
 * 类名称：Person
 * 类描述：
 * @author liubo
 * 创建时间：2019/8/19 11:21
 */
public class Person {

    private String name;

    private Integer age;

    private final Integer sex = 0;

    private Map map; // 为null不转换

    public Person() {
    }

    public Person(String name, Integer sex) {
        this.name = name;
    }

    public Person(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", map=" + map +
                '}';
    }
}
