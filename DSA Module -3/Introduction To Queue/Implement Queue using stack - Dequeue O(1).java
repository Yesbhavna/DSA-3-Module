import java.io.*;
import java.util.*;
//   
// 3 2 1
class StackQueue
{   
    Stack<Integer>st1;
    Stack<Integer>st2;
    //Function to push an element in queue by using 2 stacks.
    public StackQueue(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    void Push(int x)
    {
	   //Write your code here
        st1.push(x);
    }
    //Function to pop an element from queue by using 2 stacks.
    int Pop()
    {
	   //Write your code here
        if(st1.isEmpty() && st2.isEmpty()) return -1;
	    if(st2.isEmpty()==true){
            while(st1.isEmpty()==false){
                int topElement = st1.peek(); st1.pop();
                st2.push(topElement);
            }
        }
        int res = st2.peek(); st2.pop();
        return res;
    }
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);  
        StackQueue s = new StackQueue();	
        int q = sc.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1)
            {
                int a = sc.nextInt();
                s.Push(a);
            }
            else if(QueryType == 2)
            ans.add(s.Pop());
        q--;
        }	
        for(int x:ans)
        System.out.print(x+" ");       
     System.out.println();
    }
}