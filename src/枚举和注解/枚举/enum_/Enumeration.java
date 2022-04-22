package 枚举和注解.枚举.enum_;

public class Enumeration {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

        System.out.println(Season2.SPRING);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WINTER);

        System.out.println("-------------------------------------");
        Season2 autumn = Season2.AUTUMN;
        System.out.println(autumn.name());
        System.out.println(autumn.ordinal());

        System.out.println("-------------------------------------");
        Season2[] value = Season2.values();
        for (Season2 season2: value){
            System.out.println(season2);
        }
        System.out.println("-------------------------------------");

        Season2 summer = Season2.valueOf("SUMMER");
        System.out.println(summer);
        System.out.println("-------------------------------------");

        System.out.println(Season2.AUTUMN.compareTo(Season2.WINTER));
        System.out.println(Season2.AUTUMN.compareTo(Season2.SPRING));


    }
}


class Season {// 自定义枚举
    private String name;
    private String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season SUMMER = new Season("夏天", "炎热");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season WINTER = new Season("冬天", "寒冷");

}

enum Season2 {

    SPRING("春天", "温暖"), SUMMER("夏天", "炎热"), AUTUMN("秋天", "凉爽"), WINTER("冬天", "寒冷");

    private String name;
    private String desc;

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

//    public static final Season SPRING = new Season("春天","温暖");
//    public static final Season SUMMER = new Season("夏天","炎热");
//    public static final Season AUTUMN = new Season("秋天","凉爽");
//    public static final Season WINTER = new Season("冬天","寒冷");

}

