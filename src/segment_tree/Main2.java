package segment_tree;

public class Main2 {
    static int N = 8;
    static int a[] = {20, 10, 55, 30, 20, 40, 100, 5};
    static int tree[] = new int[32];
    public static void main(String[] args) {
        init(1, 0, N - 1);
        printTree();
        System.out.println(min(1, 0, N - 1, 1, 7));
    }
    public static void printTree() {
        for(int i=1;i<16;i++) {
            System.out.println("node=" + i + ", tree=" + tree[i]);
        }
    }
    public static int init(int node, int start, int end) {
        if(start == end) {
            return tree[node] = a[start];
        }
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(node * 2, start, mid), init(node * 2 + 1, mid + 1, end));
    }
    public static int min(int node, int start, int end, int left, int right) {
        if(start > right || end < left) {
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.min(min(node * 2, start, mid, left, right), min(node * 2 +1, mid + 1, end, left, right));
    }
}
