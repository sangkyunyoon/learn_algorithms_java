package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author sangkyun.yoon
 *
 */
public class Problem11727 {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    }
    
    public static int go(int n) {
        if(n == 1) {
            return 0;
        }
        if(d[n] > 0) {
            return d[n];
        }
        d[n] = go(n-1) + 1;
        if(n%2 == 0) {
            int temp = go(n/2) + 1;
            if(d[n] > temp) {
                d[n] temp;
            }
        }
        if(n%3) {
            int temp = go(n/3) + 1;
            if(d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
}
