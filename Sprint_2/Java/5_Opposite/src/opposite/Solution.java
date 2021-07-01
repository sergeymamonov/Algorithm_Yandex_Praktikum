package opposite;

public class Solution {
    public static Node<String> solution(Node<String> head) {
        Node<String> current = head;
        Node<String> previous = null;
        Node<String> tmp;
        while (current != null) {
            tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        head = previous;
        return head;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null, null);
        Node<String> node2 = new Node<>("node2", node3, null);
        Node<String> node1 = new Node<>("node1", node2, null);
        Node<String> node0 = new Node<>("node0", node1, null);
        Node<String> newNode = solution(node0);
        /*
        result is : newNode == node3
        node3.next == node2
        node2.next == node1
        node2.prev == node3
        node1.next == node0
        node1.prev == node2
        node0.prev == node1
        */
    }
}
