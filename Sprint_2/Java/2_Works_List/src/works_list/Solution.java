package works_list;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void solution(Node<String> head) {
        Node<String> current = head;
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            while (current.next != null) {
                bufferedWriter.write(current.value + "\n");
                current = current.next;
            }
                bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        solution(node0);
        /*
        Output is:
        node0
        node1
        node2
        node3
        */
    }
}



