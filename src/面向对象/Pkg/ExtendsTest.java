package 面向对象.Pkg;

public class ExtendsTest {
    public static void main(String[] args) {
        PC pc = new PC("intel", "16500Ti", "512GB", "DELL");
        pc.printInfo();

        NotePad notePad = new NotePad("intel", "16500Ti", "512GB", "DELL", "white");
        notePad.printInfo();
    }
}

class Computer {
    String CPU, neiCun, yinPang;

    public Computer() {
    }

    public Computer(String CPU, String neiCun, String yinPang) {
        this.CPU = CPU;
        this.neiCun = neiCun;
        this.yinPang = yinPang;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getNeiCun() {
        return neiCun;
    }

    public void setNeiCun(String neiCun) {
        this.neiCun = neiCun;
    }

    public String getYinPang() {
        return yinPang;
    }

    public void setYinPang(String yinPang) {
        this.yinPang = yinPang;
    }

    public String getDetails() {
        return "CPU=" + CPU + " neiCun=" + neiCun + " yinPang=" + yinPang;
    }
}

class PC extends Computer {
    String brand;

    public PC(String CPU, String neiCun, String yinPang, String brand) {
        super(CPU, neiCun, yinPang);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println("PC信息: " + getDetails() + " brand = " + brand);
    }

}

class NotePad extends PC {
    String color;

    public NotePad(String CPU, String neiCun, String yinPang, String brand, String color) {
        super(CPU, neiCun, yinPang, brand);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo() {
        System.out.println("NotePad信息: " + getDetails() + " brand = " + brand + " color=" + color);
    }
}
