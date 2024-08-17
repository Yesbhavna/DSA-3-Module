import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A,B));
	}
}

class Solution{
    public int search(final int[] a, int target) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low+ high) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[low] <= a[mid]) {
                // left is sorted
                if (a[low] <= target && a[mid] > target) {
                    // in the range
                    high = mid - 1;
                } else {
                    // not in range
                    low = mid + 1;
                }
            } else {
                // right is sorted
                if (a[mid] < target && a[high] >= target) {
                    // in the range
                    low = mid + 1;
                } else {
                    // not in range
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}