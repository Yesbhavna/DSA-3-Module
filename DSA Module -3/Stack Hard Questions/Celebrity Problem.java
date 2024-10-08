import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int M[][], int n)
    {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if (M[p1][p2] == 0) {
                // p2 can never be a celeb
                st.push(p1);
            } else {
                // p1 can never be a celeb
                st.push(p2);
            }
        }

        int pCeleb = st.pop();

        for (int c = 0; c < n; c++) {
            if (pCeleb != c && M[pCeleb][c] == 1) {
                return -1;
            }
        }

        for (int r = 0; r < n; r++) {
            if (r != pCeleb && M[r][pCeleb] == 0) {
                return -1;
            }
        }

        return pCeleb;
    }

}