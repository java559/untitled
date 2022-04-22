package 面向对象.内部类.匿名内部类;

public class InnerClassExercise {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell(){
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        System.out.println(bell.getClass());
        bell.ring();
    }
}
