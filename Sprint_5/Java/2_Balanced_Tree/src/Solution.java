public class Solution {
    public static boolean treeSolution(Node head) {
        return DFS(head) != -1;
    }

    private static int DFS (Node node) {
        if (node == null) {
            return 0;
        }

        int leftSubTreeHeight = DFS(node.left);
        if (leftSubTreeHeight == -1) {
            return -1;
        }

        int rightSubTreeHeight = DFS(node.right);
        if (rightSubTreeHeight == -1) {
            return -1;
        }

        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

        /** Comment it before submitting
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    **/

    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}
