import utilities.MyArrayList;
import utilities.MyDLL;
import utilities.MyQueue;
import utilities.MyStack;

public class Main {

    public static void main(String[] args) {
        // Demonstrate MyArrayList
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("MyArrayList: " + arrayList);

        // Demonstrate MyDll
        MyDLL<Integer> linkedList = new MyDLL<>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println("MyDLL: " + linkedList);

        // Demonstrate MyQueue
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println("MyQueue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        // Demonstrate MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println("MyStack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
