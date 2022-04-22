package 数据结构.链表;

import java.util.LinkedList;

public class LinkedList_ {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("依次添加1，2，3后的链表：" + list);

        list.add(2, 99);
        System.out.println("在下标为2的位置插入99后的链表：" + list);

        list.addFirst(7);
        System.out.println("在表头追加7后的链表" + list);

        int element = list.get(2);
        System.out.println("下标为2的元素：" + element);

        int index = list.indexOf(99);
        System.out.println("元素99的下标：" + index);

        list.set(2,88);
        System.out.println("将下标为2的元素改为88后的链表："+list);

        list.remove(2);
        System.out.println("删除下标为2的元素后的链表："+list);

        int length = list.size();
        System.out.println("链表的长度："+length);

    }
}
