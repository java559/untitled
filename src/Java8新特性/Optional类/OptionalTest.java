package Java8新特性.Optional类;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
//        girl = null;
        //of(T t) : 保证t是非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //ofNullable（T t) : t可以是null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("杨超越"));
        System.out.println(optionalGirl);
        System.out.println(girl1);
    }

    @Test
    public void test3(){
        Boy boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
        System.out.println();

        Boy boy1 = new Boy();
        String girlName2 = getGirlName2(boy1);
        System.out.println(girlName2);
        System.out.println();

        Boy boy2 = new Boy(new Girl("杨超越"));
        String girlName3 = getGirlName2(boy2);
        System.out.println(girlName3);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    //优化后
    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if (girl!=null){
                return girl.getName();
            }
        }
        return null;
    }
    //使用Optional类优化后
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("古力娜扎"));
        return girl1.getName();
    }
}
