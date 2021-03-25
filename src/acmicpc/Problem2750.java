package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem2750 {
    
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        
        //long startTime = System.nanoTime();
        ////long start = System.currentTimeMillis();
        Instant start = Instant.now();
        
        //ArrayList<Integer>[] aList = new ArrayList[10];
        //ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens()) {
            list.add(Integer.valueOf(st.nextToken()));
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
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
