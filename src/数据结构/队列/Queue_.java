package 数据结构.队列;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_ {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("依次添加1，2，3后的队列：" + queue);

        int temp1 = queue.peek();
        System.out.println("队首元素："+temp1);

        int temp2 = queue.poll();
        System.out.println("队首元素："+temp2);
        System.out.println("删除队首元素后的队列："+queue);

        System.out.println("队列是否为空："+queue.isEmpty());

        int length = queue.size();
        System.out.println("队列长度："+length);

        System.out.print("遍历队列的元素：");
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+"\t");
        }

    }
}
