package linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int size = 0;
    private static Node head = null;
    private static Node current = null;
    private static Node previous = null;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int commandQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        String command;
        for (int i = 0; i < commandQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            command = stringTokenizer.nextToken();
            switch (command) {
                case ("get"):
                    get();
                    break;
                case ("put"):
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    put(number);
                    break;
                case ("size"):
                    size();
            }
        }
    }

    public static void get() {
        if (size == 0) {
            System.out.println("error");
            return;
        }
        System.out.println(head.getValue());
        head = head.getPrevious();
        size--;
    }

    public static void put(int number) {
        if (size == 0) {
            head = new Node(number, null);
            current = head;
        } else {
            Node newNode = new Node(number, null);
            current.setPrevious(newNode);
            current = newNode;
        }
        size++;
    }

    public static void size() {
        System.out.println(size);
    }
}
