package 集合.list_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", 100, "曹雪芹"));
        list.add(new Book("西游记", 10, "吴承恩"));
        list.add(new Book("水浒传", 9, "施耐庵"));
        list.add(new Book("三国演绎", 80, "罗贯中"));
        list.add(new Book("西游记", 10, "吴承恩"));

        for (Object book : list) {
            System.out.println(book);
        }
        System.out.println("----------------------------------------------------------");

        sort(list);

        for (Object book : list) {
            System.out.println(book);
        }

    }
    public static void sort(List list){
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (((Book) list.get(j)).getPrice() > ((Book) list.get(j + 1)).getPrice()){
                    Book temp = (Book)list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + getName() + "\t\t价格：" + getPrice() + "\t\t作者：" + getAuthor();
    }
}
