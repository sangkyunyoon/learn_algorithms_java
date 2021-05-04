package rmq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class rmq_segment_tree {
    public static void main(String[] args) throws IOException {
        SegmentTree t = new SegmentTree();
        t.init_min(0, 11, 1);
        t.printTree();
        //System.out.println("0부터 12까지의 구간 합: " + t.sum(0, 11, 1, 0, 12));
        //System.out.println("3부터 8까지의 구간 합: " + t.sum(0, 11, 1, 3, 8));
        //System.out.println("3부터 9까지의 최소 값: " + t.query(0, 9, 1, 3, 9));
    }
    public static void nain(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		a = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		
		int x = (int) Math.ceil(Math.log(N)/Math.log(2));
		int size = (int)Math.pow(2, x)*2;
		tree=new long[size];
		
		init(1,0,N-1);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			start=Integer.parseInt(st.nextToken());
			end=Integer.parseInt(st.nextToken());
			
			System.out.println(min_num(1,0,N-1,start-1,end-1));
		}
	}
    static int N,M;
	static int a[] = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
	static int start,end;
	static long tree[] = new long[32];
    static long min_num(int node, int start, int end, int left, int right) {
		if(left > end || right < start) { //노드를 벗어 났을때
			return Integer.MAX_VALUE;
		} 
		if(left <= start && right >= end) { //마지막 노드일때
			return tree[node];
		}
		int mid = (start+end)/2; 
		return Math.min(min_num(node*2,start,mid,left,right), min_num(node*2+1,mid+1,end,left,right)); // 자식 노드가 있을때 
	}
	static long init(int node, int start, int end) {
		if(start==end)
			 return tree[node] = a[start];
		
		int mid=(start+end)/2;
		return tree[node]=Math.min(init(node*2,start,mid), init(node*2+1,mid+1,end)); //가장 값을 넣어야 하므로, 가장 작은 값으로 갱신해 준다.
	}
}
class SegmentTree {
    int tree[] = new int[32];
    long tree2[] = new long[32];
    //int a[] = {5, 8, 7, 3, 2, 5, 1, 8, 9, 8, 7, 3};
    int a[] = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    //int a[] = {3, 6, 2, 5, 3, 1, 8, 9, 7, 3};
    public int init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = a[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }
    public void printTree() {
        for(int i=1;i<a.length;i++) {
            System.out.println("node=" + i + ", tree=" + tree[i]);
        }
    }
    public int sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }    
    public int query(int start, int end, int node, int i, int j) {
        if(i > end || j < start) {
            return -1;
        }
        if(i <= start && end <= j) {
            return a[node];
        }
        int mid = (start + end) / 2;    
        int m1 = query(node * 2, start, mid, i, j);
        int m2 = query(node * 2 + 1, mid + 1, end, i, j);
        if(m1 == -1) {
            return m2;
        } else if(m2 == -1) {
            return m1;
        } else {
            return Math.min(m1, m2);
        }
    }
    long min_num(int start, int end, int node, int left, int right) {
		if(left > end || right < start) { //노드를 벗어 났을때
			return Integer.MAX_VALUE;
		} 
		if(left <= start && right >= end) { //마지막 노드일때
			return tree2[node];
		}
		int mid = (start+end)/2; 
		return Math.min(min_num(node*2,start,mid,left,right), min_num(node*2+1,mid+1,end,left,right)); // 자식 노드가 있을때 
	}
	long init_min(int start, int end, int node) {
		if(start==end)
			 return tree2[node] = a[start];
		
		int mid=(start+end)/2;
		return tree2[node]=Math.min(init(node*2,start,mid), init(node*2+1,mid+1,end)); //가장 값을 넣어야 하므로, 가장 작은 값으로 갱신해 준다.
	}
}
