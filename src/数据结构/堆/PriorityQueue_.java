package 数据结构.堆;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueue_ {
    public static void main(String[] args) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>(); //最小堆
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder()); //最大堆
        minheap.add(10);
        minheap.add(9);
        minheap.add(8);
        minheap.add(11);
        minheap.add(2);
        minheap.add(2);
        maxheap.add(10);
        maxheap.add(9);
        maxheap.add(8);
        maxheap.add(11);
        maxheap.add(2);
        maxheap.add(2);
        System.out.println(minheap);
        System.out.println(maxheap);

        System.out.println(minheap.peek());
        System.out.println(maxheap.peek());

        System.out.println(minheap.poll());
        System.out.println(maxheap.poll());

        System.out.println(minheap.size());
        System.out.println(maxheap.size());

        //遍历
        while (!minheap.isEmpty()){
            System.out.print(minheap.poll()+" ");
        }

    }
}
