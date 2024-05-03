package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _02_No_1991 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        class Node {
            Node parent;
            Node left;
            Node right;
            final String code;

            public Node(Node parent, Node left, Node right, String code) {
                this.parent = parent;
                this.left = left;
                this.right = right;
                this.code = code;
            }

            public void preorder(StringBuilder sb) {
                sb.append(code);
                if (left != null) {
                    left.preorder(sb);
                }
                if (right != null) {
                    right.preorder(sb);
                }
            }

            public void inorder(StringBuilder sb) {
                if (left != null) {
                    left.inorder(sb);
                }
                sb.append(code);
                if (right != null) {
                    right.inorder(sb);
                }
            }

            public void postorder(StringBuilder sb) {
                if (left != null) {
                    left.postorder(sb);
                }
                if (right != null) {
                    right.postorder(sb);
                }
                sb.append(code);
            }
        }

        Map<String, Node> binaryTreeMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String[] nodeInfo = br.readLine().split(" ");
            if (binaryTreeMap.get(nodeInfo[0]) == null) {
                binaryTreeMap.put(nodeInfo[0], new Node(null, null, null, nodeInfo[0]));
            }
            if (!nodeInfo[1].equals(".") && binaryTreeMap.get(nodeInfo[1]) == null) {
                binaryTreeMap.put(nodeInfo[1], new Node(null, null, null, nodeInfo[1]));
            }
            if (!nodeInfo[2].equals(".") && binaryTreeMap.get(nodeInfo[2]) == null) {
                binaryTreeMap.put(nodeInfo[2], new Node(null, null, null, nodeInfo[2]));
            }
            Node parent = binaryTreeMap.get(nodeInfo[0]);
            Node left = binaryTreeMap.get(nodeInfo[1]);
            Node right = binaryTreeMap.get(nodeInfo[2]);

            parent.left = left;
            parent.right = right;
            if (left != null) {
                left.parent = parent;
            }
            if (right != null) {
                right.parent = parent;
            }
        }
        Node a = binaryTreeMap.get("A");
        StringBuilder preorderSb = new StringBuilder();
        StringBuilder inorderSb = new StringBuilder();
        StringBuilder postorderSb = new StringBuilder();
        a.preorder(preorderSb);
        a.inorder(inorderSb);
        a.postorder(postorderSb);
        System.out.println(preorderSb.toString());
        System.out.println(inorderSb.toString());
        System.out.println(postorderSb.toString());
    }
}
