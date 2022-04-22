package poly;

import sun.rmi.transport.proxy.RMIMasterSocketFactory;

public class poly01 {
    public static void main(String[] args) {

        Master master = new Master("小明");
        Cat huaMao = new Cat("huaMao");
        Fish caoYu = new Fish("caoYu");

        master.feed(huaMao, caoYu);

        Dog wangCai = new Dog("wangCai");
        Boon guTou = new Boon("guTou");

        master.feed(wangCai, guTou);

        Animal animal = new Cat("aa");
        Cat cat = (Cat)animal;

        System.out.println(cat.getName());

    }
}

class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void feed(Cat cat,Fish fish){
//        System.out.println("主人 "+getName()+" 给 "+cat.getName()+" 喂食 "+fish.getName());
//    }
//
//    public void feed(Dog dog,Boon boon){
//        System.out.println("主人 "+getName()+" 给 "+dog.getName()+" 喂食 "+boon.getName());
//    }

    public void feed(Animal animal, Food food) {
        System.out.println("主人 " + getName() + " 给 " + animal.getName() + " 喂食 " + food.getName());
    }

}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Food {
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Fish extends Food {
    public Fish(String name) {
        super(name);
    }
}

class Boon extends Food {
    public Boon(String name) {
        super(name);
    }
}

