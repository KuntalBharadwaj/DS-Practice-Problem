import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {

        // int left[] = new int[h.size()];
        // int right[] = new int[h.size()];

        int maxcount = 0;

        for(int i=0;i<h.size();i++) {
            int count1 = 0;

            int j = 0;
            if(i == 0) j = 0;
            else j = i-1;
            while(j >= 0) {
                if(h.get(i) > h.get(j)) break;
                if(h.get(i) <= h.get(j)) count1++;
                j--;
            }

            int k = i+1;
            while(k < h.size()) {
                if(h.get(i) > h.get(k)) break;
                if(h.get(i) <= h.get(k)) count1++;
                k++;
            }
            System.out.println(count1 + " " + count1);
            maxcount = Math.max(maxcount,(count1+1)*h.get(i));
        }
        // Write your code here
        return maxcount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
