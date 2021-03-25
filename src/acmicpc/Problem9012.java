package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem9012 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            left.push(input[i]);
        }
        int n = Integer.parseInt(br.readLine());
        for (int j = 0; j < n; j++) {
            String[] line = br.readLine().split(" ");
            char what = line[0].charAt(0);
            if(what == 'L') {
                if(!left.empty()) {
                    right.push(left.pop());
                }
            } else if(what == 'D') {
                if(!right.empty()) {
                    left.push(right.pop());
                }
            } else if(what == 'B') {
                if(!left.empty()) {
                    left.pop();
                }
            } else if(what == 'P') {
                left.push(line[1].charAt(0));
            }
        }
        while(!left.empty()) {
            right.push(left.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }

}
