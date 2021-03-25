package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem10866 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String line = bf.readLine();
            int N = Integer.valueOf(line);
            //1 ≤ N ≤ 10,000
            if(N < 1 || N > 10000) {
                System.exit(0);
            }

            Deque<Integer> deque = new ArrayDeque<Integer>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String[] str = bf.readLine().split(" ");
                String cmd = str[0];
                if (cmd.equals("push_front")) {
                    deque.addFirst(Integer.valueOf(str[1]));
                } else if (cmd.equals("push_back")) {
                    deque.addLast(Integer.valueOf(str[1]));
                } else if (cmd.equals("pop_front")) {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                        sb.append("-1").append("\n");
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                } else if (cmd.equals("pop_back")) {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollLast());
                    }
                } else if (cmd.equals("size")) {
                    System.out.println(deque.size());
                } else if (cmd.equals("empty")) {
                    if (deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                } else if (cmd.equals("front")) {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.getFirst());
                    }
                } else if (cmd.equals("back")) {
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.getLast());
                    }
                }
            }
        }
    }
}
