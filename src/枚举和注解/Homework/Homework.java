package 枚举和注解.Homework;

public class Homework {
    public static void main(String[] args) {
        Color.RED.show();

        Color green = Color.GREEN;
        green.show();

        switch (green){
            case RED:
                System.out.println("红色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("匹配不到");
                break;
        }
    }
}

interface IColor {
    void show();
}

enum Color implements IColor {

    RED(255, 0, 0), BLUE(0, 0, 255),
    BLACK(0, 0, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue, greenValue, blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(this.name()+"(R:" + getRedValue() + ", G:" + getGreenValue() + ", B:" + getBlueValue()+")");
    }

    public int getRedValue() {
        return redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }
}


