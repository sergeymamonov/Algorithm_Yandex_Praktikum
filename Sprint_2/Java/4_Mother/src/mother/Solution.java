package mother;

public class Solution {
    public static int solution(Node<String> head, String elem) {
        Node<String> current = head;
        int index = 0;
        while (current.next != null) {
            if (current.value.equals(elem)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        int idx = solution(node0, "node2");
        // result is : idx == 2
    }
}
