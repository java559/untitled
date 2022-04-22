package 泛型;

@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<String>("hsp");
        System.out.println(stringPerson.f());
        System.out.println(stringPerson.s.getClass());

        Person<Integer> integerPerson = new Person<>(123);
        System.out.println(integerPerson.f());
        System.out.println(integerPerson.s.getClass());
    }
}
class Person<E>{
    E s;

    public Person(E s) {
        this.s = s;
    }

    public E f(){
        return s;
    }
}
