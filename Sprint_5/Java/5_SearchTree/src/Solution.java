import java.util.ArrayList;

public class Solution {
    public static boolean treeSolution(Node head) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (head.left != null) {
            treeSolution(head.left);
        }
        nodes.add(head.value);
        if (head.right != null) {
            treeSolution(head.right);
        }

        if (nodes.size() >= 2) {
            int previous = nodes.get(0);
            for (int i = 1; i < nodes.size(); i++) {
                if (nodes.get(i) <= previous) {
                    return false;
                }
            }
        }

//        nodes.add(head);
//        while (nodes.iterator().hasNext()) {
//            if (nodes.getFirst().left != null) {
//                if (nodes.getFirst().left.value < nodes.getFirst().value) {
//                    nodes.add(nodes.getFirst().left);
//                } else {
//                    return false;
//                }
//            }
//            if (nodes.getFirst().right != null) {
//                if (nodes.getFirst().right.value > nodes.getFirst().value) {
//                    nodes.add(nodes.getFirst().right);
//                }
//            }
//        }
        return true;
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
