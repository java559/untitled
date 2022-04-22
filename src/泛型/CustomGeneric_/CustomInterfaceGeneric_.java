package 泛型.CustomGeneric_;

@SuppressWarnings({"all"})
public class CustomInterfaceGeneric_ {
    public static void main(String[] args) {

    }
}

interface IUsb<U, R> {
    int n = 10;

    //    U name;
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    default R method(U u) {
        return null;
    }
}
interface IA extends IUsb<String,Double>{

}

class AA implements IA{

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}

class BB implements IUsb<Integer,Float>{

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
