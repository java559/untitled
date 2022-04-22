package 面向对象.零钱通项目.OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    boolean loop = true;
    Scanner input = new Scanner(System.in);
    String choice;

    String details = "------------零钱通明细---------------";

    double money;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String note;

    void mainMenu(){
        do {
            System.out.println("\n=============零钱通菜单(OOP)=============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.print("请选择（1-4）：");
            choice = input.next();
            switch (choice) {
                case "1":
                    showDetail();
                    break;
                case "2":
                    income();
                    break;
                case "3":
                    pay();
                    break;
                case "4":
                    exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }

        } while (loop);
    }

    void showDetail(){
        System.out.println(details);
    }

    void income(){
        System.out.print("收益入账金额: ");
        money = input.nextDouble();
        if (money <= 0) {
            System.out.println("收益入账金额 不能 小于 0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    void pay(){
        System.out.print("消费说明: ");
        note = input.next();
        System.out.print("消费金额: ");
        money = input.nextDouble();
        if (money <= 0 || money > balance) {
            System.out.println("消费金额 必须 在 0-" + balance);
            return;
        }
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    void exit(){
        while (true) {
            System.out.println("你确定要退出吗？ y/n");
            choice = input.next();
            if (choice.equals("y") || choice.equals("n"))
                break;
        }
        if (choice.equals("y"))
            loop = false;
    }



}
