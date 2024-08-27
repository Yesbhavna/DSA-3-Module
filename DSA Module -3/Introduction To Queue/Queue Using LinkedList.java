import java.util.*;

class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data= data;
        this.next = null;
    }
}
class Queue {
    //Write your code here

    private Node front = null;
    private Node rear = null;
    public void push(int value) {
        //Write your code here
        Node newnode = new Node(value);
        if(front == null && rear == null){
            front = rear = newnode;
        }else{
            rear.next = newnode;
            rear = rear.next;
        }
    }
    public int pop() {
        //Write your code here
        int val = this.front.data;
        front = front.next;
        return val;
    }
    public int front() {
        //Write your code here
        int val = this.front.data;
        return val;
    }
    public int getSize() {
        //Write your code here
        Node temp = front;
        int count =0;
        while(temp != null){
            count += 1;
            temp = temp.next;
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if(op == 1) {
                int x = sc.nextInt();
                q.push(x);
            }
            else if(op == 2) {
                System.out.println(q.pop());
            }
            else if(op == 3)
                System.out.println(q.front());
            else if(op == 4)
                System.out.println(q.getSize());
        }
    }
}