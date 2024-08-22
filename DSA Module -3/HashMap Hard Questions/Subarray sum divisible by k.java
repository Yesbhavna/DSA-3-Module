import java.io.*;
import java.util.*;

public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k){
        // Write code here 

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cumSum =0;
        int count = 0;
        for(int i =0; i< n ; i++){
            cumSum += arr[i];
            int remainder = cumSum%k;
            if(remainder <0){ // handling the negative scenerio
                remainder += k ;
            }
            count += map.getOrDefault(remainder,0);//add count the subarray with same remainder
            map.put(remainder, map.getOrDefault(remainder,0)+1);

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}