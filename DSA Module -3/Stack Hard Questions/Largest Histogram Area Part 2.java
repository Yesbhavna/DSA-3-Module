import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i= 0; i < n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, (int)n));
	}
}

class Solution
{
    public static long maximumArea(long hist[], int n) {
        // stack -> people looking for nsel
        Stack<Integer> st = new Stack<>();

        long maxArea = 0;

        // move -> right to left
        for (int i = n - 1; i >= 0; i--) {
            long ele = hist[i];

            while (st.size() > 0 && ele < hist[st.peek()]) {
                int idx = st.pop();
                int LB = i;

                int RB = n;
                if (st.size() > 0) {
                    RB = st.peek();
                }

                int w = RB - LB - 1;
                long area = w * hist[idx];
                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while (st.size() > 0) {
            int idx = st.pop();
            int LB = -1;

            int RB = n;
            if (st.size() > 0) {
                RB = st.peek();
            }

            int w = RB - LB - 1;
            long area = w * hist[idx];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}