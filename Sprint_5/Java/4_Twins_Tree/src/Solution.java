import java.util.LinkedList;

public class Solution {
    public static boolean treeSolution(Node head1, Node head2) {
        LinkedList<Node> tree1 = new LinkedList<>();
        LinkedList<Node> tree2 = new LinkedList<>();
        tree1.add(head1);
        tree2.add(head2);
        while (tree1.iterator().hasNext() && tree2.iterator().hasNext()) {
            if (tree1.getFirst().left != null) {
                tree1.add(tree1.getFirst().left);
            } else {
                if (tree2.getFirst().left != null) {
                    return false;
                }
            }
            if (tree2.getFirst().left != null) {
                tree2.add(tree2.getFirst().left);
            } else {
                if (tree1.getFirst().left != null) {
                    return false;
                }
            }
            if (tree1.getFirst().right != null) {
                tree1.add(tree1.getFirst().right);
            } else {
                if (tree2.getFirst().right != null) {
                    return false;
                }
            }
            if (tree2.getFirst().right != null) {
                tree2.add(tree2.getFirst().right);
            } else {
                if (tree1.getFirst().right != null) {
                    return false;
                }
            }

            Node tree1CurrentNode = tree1.removeFirst();
            Node tree2CurrentNode = tree2.removeFirst();
            if (tree1CurrentNode.value != tree2CurrentNode.value) {
                return false;
            }
        }
        return tree1.isEmpty() && tree2.isEmpty();
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

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    **/

    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
        assert treeSolution(node3, node6);
    }
}
