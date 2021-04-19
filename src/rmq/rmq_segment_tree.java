package rmq;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class rmq_segment_tree {
    public static void nain(String[] args) throws IOException {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(nm.nextToken());
        int M = Integer.valueOf(nm.nextToken());
        */
        /**
         * 75, 30, 100, 38, 50, 51, 52, 20, 81, 5
         */
        int a[] = new int[]{75, 30, 100, 38, 50, 51, 52, 20, 81, 5};
        Tree t = new Tree();
        //t.init(a, 0, a.length - 1);

    }
    static int[] arr;
    static int[] segTree1;
    static int[] segTree2;
    static int N, M, a, b;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] sArr;
    
    static int makeTree1(int idx, int start, int end){
        int mid = (start + end) / 2;
        
        if(start == end)
            return segTree1[idx] = arr[start];
        else
            return segTree1[idx] = Math.max(makeTree1(2 * idx, start, mid), makeTree1(2 * idx + 1, mid + 1, end));     
    }
    
    static int makeTree2(int idx, int start, int end){
        int mid = (start + end) / 2;
        
        if(start == end)
            return segTree2[idx] = arr[start];
        else
            return segTree2[idx] = Math.min(makeTree2(2 * idx, start, mid), makeTree2(2 * idx + 1, mid + 1, end));     
    }
    
    static int findTree1(int idx, int start, int end, int fs, int fe){
        if(fe < start || fs > end)
            return 0;
        else if(fs <= start && end <= fe)
            return segTree1[idx];
        else{
            int mid = (start + end) / 2;
            return Math.max(findTree1(2 * idx, start, mid, fs, fe), findTree1(2 * idx + 1, mid + 1, end, fs, fe));    
        }
    }
    
    static int findTree2(int idx, int start, int end, int fs, int fe){
        if(fe < start || fs > end)
            return 1000000000;
        else if(fs <= start && end <= fe)
            return segTree2[idx];
        else{
            int mid = (start + end) / 2;
            return Math.min(findTree2(2 * idx, start, mid, fs, fe), findTree2(2 * idx + 1, mid + 1, end, fs, fe));    
        }
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        sArr = br.readLine().split(" ");
        
        N = Integer.valueOf(sArr[0]);
        M = Integer.valueOf(sArr[1]);
        
        arr = new int[N + 1];
        segTree1 = new int[4 * (N + 1)];
        segTree2 = new int[4 * (N + 1)];
        
        for(int i = 1; i < arr.length; i++)
            arr[i] = Integer.valueOf(br.readLine());
            
        makeTree1(1, 1, N);
        makeTree2(1, 1, N);
        
        for(int i = 0; i < M; i++){
            sArr = br.readLine().split(" ");
            
            a = Integer.valueOf(sArr[0]);
            b = Integer.valueOf(sArr[1]);
            
            bw.write(findTree2(1, 1, N, a, b) + " ");
            bw.write(findTree1(1, 1, N, a, b) + "\n");
        }
        bw.flush();
    }
}
//https://stack07142.tistory.com/216
class SegmentTree {
    int[] segArr;
    public SegmentTree(int arr, int n) {
        segArr = new int[n * 4];
    }
}
