package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem1406 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if(c == '(') {
                stack.push(i);
            } else {
                int peek = stack.pop();
                if(i - peek > 1) {
                    sum += 1;
                } else {
                    sum += stack.size();
                }
            }
        }
        System.out.println(sum);
    }

}
