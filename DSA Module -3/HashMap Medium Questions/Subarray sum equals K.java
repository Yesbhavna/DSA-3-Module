import java.io.*;
import java.util.*;
 
 class Solution
{
         static int solve(int N, int[] Arr, int K){
       // Write your code here
       HashMap<Integer,Integer> map = new HashMap<>();// create hasmap
       int cumulativeSum =0;//prefix sum
       int count =0;// used to track the number ofsubarray
       map.put(0,1);// to handle cases where the subarray sum is exactly k without needing to subtract anything
       for(int i =0; i<N; i++){
        cumulativeSum += Arr[i];
        count += map.getOrDefault(cumulativeSum-K,0);//check if (cumulativeSum-k) exists in the map
        //. if it does, it means there is a subarray ending at the current index that sums to k
        // Add the freqquency of (cumulativeSum - k) to count
        map.put(cumulativeSum,map.getOrDefault(cumulativeSum,0)+1);

       }
    return count ;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_Arr = br.readLine().split(" ");
         int[] Arr = new int[N];
         for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
         {
         	Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
         }
         int K = Integer.parseInt(br.readLine().trim());
 
         int out_ =  Solution.solve(N, Arr, K);
         System.out.println(out_);
 
         wr.close();
         br.close();
    }
}