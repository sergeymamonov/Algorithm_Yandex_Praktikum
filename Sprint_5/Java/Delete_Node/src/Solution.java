public class Solution {
    public static Node remove(Node root, int key) {
        /*
        if (root == null) {
            return null;
        }
         */

        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = true;

        while (currentNode.getValue() != key) {
            parentNode = currentNode;
            if (key < root.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null) {
                return null;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == root) {
                root = null;
            } else if (isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        } else if (currentNode.getRight() == null) {
            if (currentNode == root) {
                root = currentNode.getLeft();
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }
        } else if (currentNode.getLeft() == null) {
            if (currentNode == root) {
                root = currentNode.getRight();
            } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(parentNode.getRight());
            }
        } else {
            Node heir = getHeir(currentNode);
            if (currentNode == root) {
                root = heir;
            } else if (isLeftChild) {
                parentNode.setLeft(heir);
            } else {
                parentNode.setRight(heir);
            }
        }

        return root;
    }

    public static Node getHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRight();
        while (currentNode != null) {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeft();
        }

        if (heirNode != node.getRight()) {
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;
    }

        /** Comment it before submitting
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    **/

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}