package rmq;

import java.io.IOException;

public class rmq_segment_tree {
    public static void main(String[] args) throws IOException {
        SegmentTree t = new SegmentTree();
        t.init(0, 11, 1);
        t.printTree();
        System.out.println("0부터 12까지의 구간 합: " + t.sum(0, 11, 1, 0, 12));
        System.out.println("3부터 8까지의 구간 합: " + t.sum(0, 11, 1, 3, 8));
        
    }
}
class SegmentTree {
    int tree[] = new int[32];
    //int a[] = {5, 8, 7, 3, 2, 5, 1, 8, 9, 8, 7, 3};
    int a[] = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
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
}
