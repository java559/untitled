package 集合.Collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new Dog("wangCai",5));
        col.add(new Dog("daHuang",4));

        Iterator iterator = col.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println("obj="+obj);
        }

        System.out.println("====================第二次遍历====================");
        for(Object obj : col){
            System.out.println("obj="+obj);
        }

    }
}
class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}