package 数据结构.栈;

import java.util.Stack;

public class Stack_ {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

        int temp1 = stack.peek();
        System.out.println("栈顶元素：" + temp1);

        int temp2 = stack.pop();
        System.out.println("栈顶元素：" + temp2);
        System.out.println("删除栈顶元素后的栈：" + stack);

        int length = stack.size();
        System.out.println("栈的长度：" + length);

        System.out.println("栈是否为空:" + stack.isEmpty());

        System.out.print("遍历栈的元素：");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }

    }
}
