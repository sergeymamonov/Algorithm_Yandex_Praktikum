import java.util.LinkedList;

public class Solution {
    public static int treeSolution(Node head) {
        int result = head.value;
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(head);
        while (nodes.iterator().hasNext()) {
            if (nodes.getFirst().value > result) {
                result = nodes.getFirst().value;
            }
            if (nodes.getFirst().left != null) {
                nodes.add(nodes.getFirst().left);
            }
            if (nodes.getFirst().right != null) {
                nodes.add(nodes.getFirst().right);
            }
            nodes.removeFirst();
        }
        return result;
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
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
