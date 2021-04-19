package tree;

public class binary_tree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Node n4 = tree.makeNode(null, 4, null);
        Node n5 = tree.makeNode(null, 5, null);
        Node n2 = tree.makeNode(n4, 2, n5);
        Node n3 = tree.makeNode(null, 3, null);
        Node n1 = tree.makeNode(n2, 1, n3);
        tree.setRoot(n1);
        tree.inorder(tree.getRoot());
        System.out.println();
        tree.preorder(tree.getRoot());
        System.out.println();
        tree.postorder(tree.getRoot());
        System.out.println();

    }
}
class Node {
    int data;
    Node left;
    Node right;
}
class Tree {
    Node node;
    public Node getRoot() {
        return node;
    };
    public void setRoot(Node root) {
        this.node = root;
    }
    public Node makeNode(Node left, int data, Node right) {
        Node node = new Node();
        node.data = data;
        node.left = left;
        node.right = right;
        return node;
    }
    public void inorder(Node node) {
        if(node != null) {
            //left root right
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }
    public void preorder(Node node) {
        if(node != null) {
            //root left right
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }
    public void postorder(Node node) {
        if(node != null) {
            //left right root
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }
}
