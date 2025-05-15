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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();

        List<Integer> primes = new ArrayList<>();
        int n = 2;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(n);
            n++;
        }

        Stack<Integer> current = new Stack<>();
        for (int i = number.size() - 1; i >= 0; i--) {
            current.push(number.get(i));
        }

        for (int i = 0; i < q; i++) {
            Stack<Integer> A = new Stack<>();
            Queue<Integer> B = new LinkedList<>();
            int prime = primes.get(i);

            while (!current.isEmpty()) {
                int plate = current.pop();
                if (plate % prime == 0) {
                    B.add(plate);
                } else {
                    A.push(plate);
                }
            }

            while (!B.isEmpty()) {
                result.add(B.poll());
            }

            current = A;
        }


        List<Integer> current2 = new ArrayList<>();

        while (!current.isEmpty()) {
            current2.add(current.pop());
        }

        for(int i=current2.size()-1;i>=0;i--) {
            result.add(current2.get(i));
        }
        return result;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
