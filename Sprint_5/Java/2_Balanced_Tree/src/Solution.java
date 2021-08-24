import java.util.LinkedList;

public class Solution {
    public static boolean treeSolution(Node head) {
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;
        int currentLevel = 1;
        LinkedList<Node> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()) {
            int listSize = list.size();
            while (listSize > 0) {
                Node currentNode = list.removeFirst();
                if (currentNode.left == null && currentNode.right == null) {
                    if (minLevel > currentLevel) {
                        minLevel = currentLevel;
                    }
                    if (maxLevel < currentLevel) {
                        maxLevel = currentLevel;
                    }
                } else {
                    if (currentNode.left != null) {
                        list.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        list.add(currentNode.right);
                    }
                }
                listSize--;
            }
            if (Math.abs(maxLevel - minLevel) > 1) {
                return false;
            }
            currentLevel++;
        }
        System.out.println("currentLevel " + currentLevel);
        System.out.println("minLevel " + minLevel);
        System.out.println("maxLevel " + maxLevel);
        return true;
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
