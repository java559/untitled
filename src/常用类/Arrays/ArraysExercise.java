package 常用类.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦~", 100);
        books[1] = new Book("金瓶梅", 100.1);
        books[2] = new Book("青年文摘~", 5);
        books[3] = new Book("java从入门到放弃", 300);
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                double i1 = ((Book) o1).price;
                double i2 = ((Book) o2).price;
                return i1-i2>0?1:-1;
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
