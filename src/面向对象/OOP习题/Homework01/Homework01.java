package 面向对象.OOP习题.Homework01;

public class Homework01 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock01 = new Frock();
        Frock frock02 = new Frock();
        Frock frock03 = new Frock();
        System.out.println(frock01.getSerialNumber());
        System.out.println(frock02.getSerialNumber());
        System.out.println(frock03.getSerialNumber());

    }
}

class Frock {

    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

}


