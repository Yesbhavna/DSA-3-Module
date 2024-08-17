import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void sqrt(int A) {
        long ans = -1;
        long low = 1; //low
        long high = (long) A;  // high

        while (low <= high) {
            long mid = low + (low-high) / 2; // mid

            if (mid * mid == A) {
                System.out.println(mid);
                return;
            } else if (mid * mid > A) {
                high = mid - 1;// number greater than mid will not be our answer so move left
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}