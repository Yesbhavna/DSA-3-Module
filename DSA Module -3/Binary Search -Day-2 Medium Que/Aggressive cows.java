class Solution{

    public static int aggressiveCows(int a[],int cows){
       //Write your code here
       int n = a.length;
       Arrays.sort(a);
       int low = 1; // min distance
       int high = a[n-1] - a[0];
       while(low<= high){
        int mid = (low +high)/2;
        if(canwePlace(a,mid,cows) == true){
            low = mid +1;
        }else high = mid-1;
       }
    return high;
    }
    public static boolean canwePlace (int a[] , int dist,int cows){
        int n = a.length;
        int count = 1;
        int last = a[0];
        for(int i = 1; i< n; i++){
            if(a[i] - last >= dist){
                count ++;
                last = a[i];
            }
            if(count == cows) return true;
        }
    return false;
    }


}