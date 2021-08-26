import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static int treeSolution(Node head) {
        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<StringBuffer> stringBuffers = new LinkedList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        nodes.add(head);
        stringBuffers.add(new StringBuffer());
        stringBuffers.getFirst().append(head.value);
        while (nodes.iterator().hasNext()) {

            if (nodes.getFirst().left != null) {
                nodes.add(nodes.getFirst().left);
                StringBuffer stringBufferLeft = new StringBuffer();
                stringBufferLeft.append(stringBuffers.getFirst()).append(nodes.getFirst().left.value);
                stringBuffers.add(stringBufferLeft);
            }
            if (nodes.getFirst().right != null) {
                nodes.add(nodes.getFirst().right);
                StringBuffer stringBufferRight = new StringBuffer();
                stringBufferRight.append(stringBuffers.getFirst()).append(nodes.getFirst().right.value);
                stringBuffers.add(stringBufferRight);
            }
            if (nodes.getFirst().left == null && nodes.getFirst().right == null) {
                numbers.add(Integer.parseInt(stringBuffers.getFirst().toString()));
            }
            nodes.removeFirst();
            stringBuffers.removeFirst();
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
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
        Node node1 = new Node(2, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(1, node4, node3);
        assert treeSolution(node5) == 275;
    }
}
