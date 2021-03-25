package acmicpc;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem1158 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        StringBuilder sb = new StringBuilder("<");
        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m; j++) {
                int v = q.poll();
                if(j == m) {
                    sb.append(v).append(", ");
                } else {
                    q.offer(v);
                }
            }
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }

}
