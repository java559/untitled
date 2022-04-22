package 面向对象.房屋出租系统;

import java.util.Scanner;

public class Fwczxt {
    public static void main(String[] args) {
        Main_menu main_menu = new Main_menu();
        main_menu.mainM();
    }
}

class Main_menu {
    boolean loop = true;
    Scanner input = new Scanner(System.in);
    String choice = "";
    String details = "编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）\n";

    public void mainM() {
        do {
            System.out.println("--------------面向对象.房屋出租系统--------------");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房源");
            System.out.println("\t\t\t3 删除房源");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退出");
            System.out.print("请选择（1-6）：");
            choice = input.next();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    find();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    xiuGai();
                    break;
                case "5":
                    roomList();
                    break;
                case "6":
                    exit();
                    break;
            }

        } while (loop);
    }

    public void add() {
        int bianHao;
        String name, phone, address, zhuangTai;
        double yueZu;

        System.out.println("--------------添加房屋--------------");
        System.out.println("编号：");
        bianHao = input.nextInt();
        System.out.print("姓名：");
        name = input.next();
        System.out.print("电话：");
        phone = input.next();
        System.out.print("地址：");
        address = input.next();
        System.out.print("月租：");
        yueZu = input.nextDouble();
        System.out.print("状态（未出租/已出租）：");
        zhuangTai = input.next();
        System.out.println("--------------添加完成--------------");

        details += bianHao + "\t\t" + name + "\t\t" + phone + "\t\t" + address + "\t\t" + yueZu + "\t\t" + zhuangTai + "\n";

    }

    public void find() {
    }

    public void delete() {
    }

    public void xiuGai() {
    }

    public void roomList() {
        System.out.println("--------------房屋列表--------------");
        System.out.println(details);
        System.out.println("-------------房屋列表完成-------------");
    }

    public void exit() {
        loop = false;
    }

}



