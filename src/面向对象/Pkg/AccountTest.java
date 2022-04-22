package 面向对象.Pkg;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("渴老师", 240000, "141592");
        account.info();
        account.setName("老");
        account.setMoney(1);
        account.setPassWord("12356");
        account.info();


    }
}

class Account {
    private String name;
    private double money;
    private String passWord;

    public Account() {
    }

    public Account(String name, double money, String passWord) {
        setName(name);
        setMoney(money);
        setPassWord(passWord);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4)
            this.name = name;
        else {
            System.out.println("输入名字长度有误，将返回默认值，请输入2-4位");
            this.name = "无名氏";
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money > 20)
            this.money = money;
        else {
            System.out.println("输入余额大小有误，将返回默认值，请输入>20");
            this.money = 200;
        }

    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord.length() == 6)
            this.passWord = passWord;
        else {
            System.out.println("输入密码长度有误，将返回默认值，请输入6位");
            this.passWord = "888888";
        }
    }

    public void info() {
        System.out.println("姓名：" + name + " 余额：" + money + " 密码：" + passWord);
    }

}
