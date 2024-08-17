// Java program to find minimum element in a sorted and
// rotated array
import java.io.*;
import java.lang.*;
import java.util.*;
class Solution {
    static int findMin(int arr[], int low, int high) {
        int potentialmin = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[low] <= arr[mid]) {
                // left side sorted so that we compare left most part with our potential answer
                potentialmin = Math.min(potentialmin, arr[low]);
                low = mid + 1;// we will eliminate this left half(i.e. low = mid+1
            } else {
                // right side sorted , in thia our min value in right side wil be the mid value
                potentialmin = Math.min(potentialmin, arr[mid]);
                high = mid - 1;//we will eliminate this right half
            }
        }

        return potentialmin;
    }
}
//If arr[low] <= arr[mid]: In this case, we identified that the left half is sorted.
//If arr[mid] <= arr[high]: In this case, we identified that the right half is sorted.
//we know left most part will be minimum
class Main {
    // Driver Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}