import java.util.*;

class twoStacks {
	int[] arr;
	int size;
	int top1, top2;

	// Constructor
	twoStacks(int n) {
		size = n;
		arr = new int[n];
		top1 = -1;
		top2 = n;
	}

	void push1(int x) {
        if (top1 + 1 < top2) {
            top1++;
            arr[top1] = x;
        }
	}

	void push2(int x) {
       if (top2 - 1 > top1) {
           top2--;
           arr[top2] = x;
       }
	}

	void pop1() {
		if (top1 == -1) {
            System.out.println(-1);
        } else {
            System.out.println(arr[top1]);
            arr[top1] = 0;
            top1--;
        }
	}

	void pop2() {
    	if (top2 == size) {
           System.out.println(-1); 
        } else {
            System.out.println(arr[top2]);
            arr[top2] = 0;
            top2++;
        }
	}
};
public class Main {

	/* Driver program to test twoStacks class */
	public static void main(String[] args)
	{
		twoStacks ts = new twoStacks(50);
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i =0; i<n; i++){
            int temp;
            temp = sc.nextInt();
            if(temp == 1) ts.pop1();
            else if(temp==3) ts.pop2();
            else if(temp == 2) {
                int temp2;
                temp2 = sc.nextInt();
                ts.push1(temp2);
            }
            else{
                int temp2;
                temp2 = sc.nextInt();
                ts.push2(temp2);
            }
        }
	}
}