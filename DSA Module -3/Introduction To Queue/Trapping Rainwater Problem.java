import java.io.*;
import java.util.*;
//most imp problem with respect to interview .////try to do run run and understand the question clearly
class Solution {
    public void TappingWater(int[] height, int n) {
        //Write code here and print output
        Stack<Integer> stack = new Stack<>();
        int ans =0 ;
        for(int i =0; i<n; i++){
            while(!stack.isEmpty() && (height[stack.peek()] < height[i])){
                int pop = height[stack.peek()];
                stack.pop();

                if(stack.isEmpty()){
                    break;
                }
                int distance = i-stack.peek()-1;
                int min_height = Math.min(height[stack.peek()],height[i])-pop;
                ans += distance * min_height;
            }
            stack.push(i);
            
        }
       System.out.println(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n= sc.nextInt();
      	    int[] height = new int[n];

      	    for(int i=0;i<n;i++)
                height[i]=sc.nextInt();
            
        
            Solution Obj = new Solution();
            Obj.TappingWater(height, n);
            
        
        sc.close();
        
    }
}