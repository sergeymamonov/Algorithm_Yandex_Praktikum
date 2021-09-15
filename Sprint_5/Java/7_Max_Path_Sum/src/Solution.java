import java.lang.Math;

public class Solution {
    public static int result = Integer.MIN_VALUE;

    public static int treeSolution(Node head) {
        getMaxPathSum(head);
        return result;
    }

    public static int getMaxPathSum(Node head) {
        if (head == null) {
            return 0;
        }

        int leftSum = Math.max(getMaxPathSum(head.left), 0);
        int rightSum = Math.max(getMaxPathSum(head.right), 0);
        result = Math.max(result, leftSum + rightSum + head.value);

        return head.value + Math.max(leftSum, rightSum);
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
        Node node1 = new Node(5, null, null);
        Node node2 = new Node(1, null, null);
        Node node3 = new Node(-3, node2, node1);
        Node node4 = new Node(2, null, null);
        Node node5 = new Node(2, node4, node3);
        assert treeSolution(node5) == 6;
    }
}
