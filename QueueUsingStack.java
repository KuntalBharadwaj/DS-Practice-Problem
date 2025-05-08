import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        int q;
        Scanner sc = new Scanner(System.in);
        q = sc.nextInt();

        while(q!=0) {
            int t = sc.nextInt();
            if(t == 1) {
                int num = sc.nextInt();
                st1.add(num);
            }

            else if(t == 2) {
                if(st2.isEmpty()) {
                    while(!st1.isEmpty()) {
                        st2.push(st1.pop());
                    }
                    st2.pop();
                    // System.out.println(st2.pop());
                }

                else {
                    st2.pop();
                    // System.out.println(st2.pop());
                }
            }

            else if(t == 3) {
                if(st2.isEmpty()) {
                    while(!st1.isEmpty()) {
                        st2.push(st1.pop());
                    }
                    System.out.println(st2.peek());
                }

                else {
                    System.out.println(st2.peek());
                }
            }


            q--;
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}