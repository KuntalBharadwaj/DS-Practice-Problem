import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        // Write your code here
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n = s1.length();
        int n2 = s2.length();

        for(int i=0;i<n;i++) {
            if(map1.containsKey(s1.charAt(i))) map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
            else map1.put(s1.charAt(i), 1);
        }

        for(int i=0;i<n2;i++) {
            if(map1.containsKey(s2.charAt(i))) map1.put(s2.charAt(i), map1.get(s2.charAt(i))-1);
            else map1.put(s2.charAt(i), -1);
        }

        int sum = 0;

        for (Integer value : map1.values()) {
            sum = sum + Math.abs(value);
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = Result.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
