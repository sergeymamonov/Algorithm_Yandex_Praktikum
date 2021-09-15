public class Solution {
    public static boolean treeSolution(Node head) {
        return isBinTree(head, null, null);
    }

    public static boolean isBinTree(Node root, Node minNode, Node maxNode) {
        if (root == null) {
            return true;
        }

        if (minNode != null && root.value <= minNode.value) {
            return false;
        }

        if (maxNode != null && root.value >= maxNode.value) {
            return false;
        }

        return isBinTree(root.left, minNode, root) && isBinTree(root.right, root, maxNode);

    }

    /**
     * Comment it before submitting
     * private static class Node {
     * int value;
     * Node left;
     * Node right;
     * <p>
     * Node(int value) {
     * this.value = value;
     * this.left = null;
     * this.right = null;
     * }
     * <p>
     * Node(int value, Node left, Node right) {
     * this.value = value;
     * this.left = left;
     * this.right = right;
     * }
     * }
     **/


    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}
