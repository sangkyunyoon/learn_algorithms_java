package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class dfs {
    public static void main(String[] args) {
        Graph g = makeGraph();
        g.dfs(0);
        System.out.println();
        g = makeGraph();
        g.bfs(0);
        System.out.println();
        g = makeGraph();
        g.dfsR(0);
        System.out.println();
        g = makeGraph();
        g.dfs(3);
        System.out.println();
        g = makeGraph();
        g.bfs(3);
        System.out.println();
        g = makeGraph();
        g.dfsR(3);
        System.out.println();
    }
    public static Graph makeGraph() {
        Graph g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 5);
        g.addEdge(6, 8);
        g.addEdge(7, 5);
        g.addEdge(8, 6);
        return g;
    }
}
class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked; 
        public Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<>();
            this.marked = false;
        }
    }
    Node[] nodes;
    public Graph(int size) {
        nodes = new Node[size];
        for(int i=0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }
    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2 .adjacent.add(n1);
        }
    }
    public void dfs() {
        dfs(0);
    }
    public void dfs(int i) {
        Node root = nodes[i];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) {
                if(n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }
    public void visit(Node node) {
        System.out.print(node.data + " ");
    }
    public void bfs() {
        bfs(0);
    }
    public void bfs(int i) {
        Node root = nodes[i];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node r = queue.poll();
            for (Node n : r.adjacent) {
                if(n.marked == false) {
                    queue.offer(n);
                    n.marked = true;
                }
            }
            visit(r);
        }
    }
    public void dfsR(Node r) {
        if(r == null) {
            return; 
        }
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if(n.marked == false) {
                dfsR(n);
            }
        }
    }
    public void dfsR(int i) {
        Node n = nodes[i];
        dfsR(n);
    }
    public void dfsR() {
        dfsR(0);
    }
}
