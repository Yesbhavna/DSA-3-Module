import java.util.*;

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int element : arr){
            map.put(element,map.getOrDefault(element,0)+1);
        }
        //Write your code here
        HashMap<Integer, Integer> map1= new HashMap<>();
        for(int element : brr){
            map1.put(element,map1.getOrDefault(element,0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int key: map1.keySet()){
            if(map.containsKey(key) == false){//check that first map has that key
                list.add(key);
            }else{
                if(map.get(key) != map1.get(key)){//checking frequency
                    list.add(key);
                }
            }
        }
        if(list.size() == 0){
            return ;
         }
         Collections.sort(list);
         for(int element: list){
             System.out.print(element + " ");
         }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}