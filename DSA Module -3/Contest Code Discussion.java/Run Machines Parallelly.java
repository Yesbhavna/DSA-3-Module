import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), k = sc.nextInt();
    int[] lifetime = new int[k];
    for (int i = 0; i < k; i++) lifetime[i] = sc.nextInt();
    sc.close();
    System.out.println(maxRunTime(n, lifetime));
  }

  public static boolean canRun(int n, int[] lifetime, long hours){ //ITERATE over batteries from largest to smallest
    long remaininglife =0;
    int machines = n;
    for(int i = lifetime.length-1; i>=0 && machines >0;i--){
      if(lifetime[i] >=  hours){
      machines--;
    }else{
      remaininglife += lifetime[i];
      }
    }
    return machines <= 0 || remaininglife >= (machines * hours);
  }

  //suppose you are checking if it is possible to run 3 machines for 5 hours each (hours = 5)
  //and we have accumulate a totlal of 20 units of battery life 
  //machines * hours = 3* 5 = 15
  //means we need exactly 15 units of battery life to run 3v machines for 5 hours....so it is feasible

  public static long maxRunTime(int n, int[] lifetime) {
    // your code here
    Arrays.sort(lifetime); //to use binary search we have to sort the array
    int totallife =0; // sum of the lifetimes of all batteries 
    for(int i =0; i<lifetime.length;i++){
      totallife += lifetime[i];
    }
    long left = 1;/// we are taking left = 1 not 0 because  binary search will check if 0 hour is feasible or not..it is not correct 
    long right = totallife/n;//....we set right like this because if we given 3 machines and batteries lifetimes [4 , 8 , 6]
    //total life = 4+8+6 = 18
    //n = 3
    //right = 18/3 = 6 the max runtime that makes sense to check is 6
    while(left<right){
      long mid = (right + left +1)/2;// we use this formula it some how round the value to max...here the que asking max number of hours
      if(canRun(n,lifetime,mid)){
        left = mid;// possibility mid our answer as when we call canrun function 
        // it check 'mid' hours is a valid and we will extend it further so set our left at mid
      }else{
        right = mid-1;// if mid hours is not feasible then reduce search space and find in that
      }
    }
    return left;
  }

}