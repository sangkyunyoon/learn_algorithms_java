package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem2741 {
    
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int num = Integer.valueOf(line.trim());
        
        //long startTime = System.nanoTime();
        ////long start = System.currentTimeMillis();
        Instant start = Instant.now();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            sb.append(i + "\n");
        }
        System.out.println(sb);
        
        //long endTime = System.nanoTime();
        ////long finish = System.currentTimeMillis();
        Instant finish = Instant.now();
        
        //long timeElapsed = endTime - startTime;
        ////long timeElapsed = finish - start;
        long timeElapsed = Duration.between(start, finish).toMillis();
        
        //System.out.println("Execution time in nanoseconds  : " + timeElapsed);
        ////System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
        System.out.println("Execution time in nanoseconds  : " + timeElapsed);
    }
}
