
// A Java program to print all anagrams together
import java.util.*;

public class Main {
    // Given a list of words in wordArr[],
    static void printAnagramsTogether(String wordArr[], int size) {
        //your code here
        HashMap<String,ArrayList<String>>map = new HashMap<>();// map stores encoding value as well as the list where all the words will be added
        ArrayList<String> foeg = new ArrayList<>();
        for(String word: wordArr){
            String enStr = encode(word);
        }
        ArrayList<String> grp = new ArrayList<>();
        if(map.containsKey(enStr) ==true){
            grp = map.get(enStr);
        }else{
            foeg.add(word);
        }
        grp.add(word);
        map.put(enStr,grp);
    }
        Collections.sort(foeg);

        for(String word: foeg){
            String enStr = encode(word);
            for(String w : map.get(enStr))
            System.out.println(w + " ");
        }


    }
    static String encode(String str){
        int[] cfa = new int[26];
        for(char ch : str.toCharArray()){
            int pos = (int)(ch-'a'); // pos
            cfa[pos]++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0; i<26; i++){
            int freq = cfa[i];
            char ch = (char)('a' + i);
            sb.append(ch);
            sb.append(freq);//d1g1o1

        }
        return sb.toString();
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] wordArr = new String[n];
        for (int i = 0; i < n; i++)
            wordArr[i] = sc.next();
        sc.close();
        printAnagramsTogether(wordArr, n);
    }
}