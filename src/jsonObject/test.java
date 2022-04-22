package jsonObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@SuppressWarnings("all")
public class test {
    public static void main(String[] args) throws Exception{
        JSONObject json = new JSONObject();
        json.put("username","zhangSan");
        json.put("password","123456");
        System.out.println(json);
        System.out.println(json.toString());

        json.element("sex", "男");
        json.put("age", 18);
        System.out.println(json);

        boolean isArray = json.isArray();
        boolean isEmpty = json.isEmpty();
        boolean isNullObject = json.isNullObject();
        System.out.println("是否数组："+isArray+", 是否空："+isEmpty+", 是否空为空对象："+isNullObject);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"zhangSan");
        jsonArray.add(1,"123456");
        jsonArray.add("123456");
        jsonArray.element("nan");
        json.element("student",jsonArray);
        System.out.println(json);
        System.out.println(jsonArray);

        Student stu = new Student("zhangSan", "456123");
        JSONObject jsonObject = JSONObject.fromObject(stu);
        System.out.println(jsonObject);

        String jsondata = "{\"username\":\"李四\", \"password\":\"123\"}";
        JSONObject json3 = JSONObject.fromObject(jsondata);
        Student stu2 = (Student)JSONObject.toBean(json3, Student.class);
        System.out.println(stu2.toString());


    }
}
