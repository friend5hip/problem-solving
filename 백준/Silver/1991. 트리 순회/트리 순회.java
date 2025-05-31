import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        Map<String, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node parentNode = tree.addNode(parent, nodeMap);
            if (i == 0) tree.root = parentNode;

            if (!left.equals(".")) {
                Node leftNode = tree.addNode(left, nodeMap);
                parentNode.addLeft(leftNode);
            }

            if (!right.equals(".")) {
                Node rightNode = tree.addNode(right, nodeMap);
                parentNode.addRight(rightNode);
            }
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }

    public static class Tree {
        Node root;

        public Node addNode(String label, Map<String, Node> nodeMap) {
            return nodeMap.computeIfAbsent(label, Node::new);
        }

        public void preOrder(Node node) {
            if (node == null) return;
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(Node node) {
            if (node == null) return;
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        public void postOrder(Node node) {
            if (node == null) return;
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

    public static class Node {
        Object data;
        Node left, right;

        public Node(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node node) {
            left = node;
        }

        public void addRight(Node node) {
            right = node;
        }
    }
}