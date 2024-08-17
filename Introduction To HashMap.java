package HashMap;

import java.util.HashMap;
import java.util.Map;

public class Introduction {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        //insertion
        map.put("Delhi",567);
        map.put("Mumbai",678);
        map.put("Delhi",788);
        map.put("Goa",788);
        System.out.println(map);

        search .containsKey()
        if(map.containsKey("Delhi")){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        how to use get
        System.out.println(map.get("Mumbai"));
        System.out.println(map.get("Nagpur"));
        int[] arr = {12,67, 87};
        for(int i =0; i<3; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int val: arr){
            System.out.print(val + " ");
        }
        System.out.println();

        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e);
//            System.out.println(e.getValue());
        }



    }
}
