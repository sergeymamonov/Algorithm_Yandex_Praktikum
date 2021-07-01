package unliked_work;

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        if (idx == 0) {
            head = head.next;
            return head;
        }
        Node<String> current = head;
        for (int i = 0; i < idx - 1; i++) {
            current = current.next;
        }
        Node<String> deleted = current.next;
        current.next = deleted.next;

        return head;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        // result is : node0 -> node2 -> node3
    }
}
