package tree;

public class binary_search_tree {
    public static void main(String[] args) {
        int target = 7;
        int r = search(0, 11, target);
        if(r == -1) {
            System.out.println(target + "을 찾을수 없습니다.");
        } else {
            System.out.println((r + 1) + "번째에서 찾았습니다.");
        }
        
    }
    static int a[] = {1, 3, 5, 7, 9, 11, 14, 15, 18, 19, 25, 28};
    public static int search(int start, int end, int target) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid] == target) {
            return mid;
        } else if(a[mid] > target) {
            return search(start, mid - 1, target);
        } else {
            return search(mid + 1, end, target);
        }
    }
}
