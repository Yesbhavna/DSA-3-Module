
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
 
    static int findMax (int[] arr, int n) {   // bitonic
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;
                if (arr[mid] < arr[mid + 1])
                    lo = mid + 1;// go to right side
                if (arr[mid] < arr[mid - 1])
                    hi = mid - 1;// go to left side
            }
            if (mid == 0) {
                if (arr[mid] > arr[mid + 1])
                    return mid;
                else
                    return mid + 1;
            }
            if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1])
                    return mid;
                else
                    return mid - 1;
            }
         }
    return -1;
    }

        static int findInAscArray (int[] arr, int lo, int hi, int tar) {
            while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] > tar) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

        static int findInDescArray (int[] arr, int lo, int hi, int tar) {
            while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] == tar) {
                return mid;
            } else if (arr[mid] > tar) {
            lo = mid + 1;
            } else {
            hi = mid - 1;
        }
    }

    return -1;
}

    static int findElement(int arr[], int n,int target) {
        // your code here
        int peak = findMax (arr, n);
        int left = findInAscArray (arr, 0, peak, target);
        int right = findInDescArray (arr, peak + 1, n - 1, target);

            if(left != -1) {
            return left;
            } else if (right != -1) {
            return right;
            } else {
            return -1;
            }
        }
    }

}