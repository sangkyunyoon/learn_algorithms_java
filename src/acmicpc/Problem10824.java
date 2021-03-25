package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem10824 {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] tokens = line.split(" ");
        String a = tokens[0] + tokens[1]; //AB
        String b = tokens[2] + tokens[3]; //CD
        long ans = Long.valueOf(a) + Long.valueOf(b);
        System.out.println(ans);
        
    }

}
