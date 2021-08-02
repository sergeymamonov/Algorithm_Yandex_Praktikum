package hash_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashTable table = new HashTable();
//        ArrayList<Node> table = new ArrayList<>();
        int commandsQuantity = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < commandsQuantity; i++) {
            int key;
            int value;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case ("put"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    table.put(key, value);
                    break;
                case ("get"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    try {
                        table.get(key);
                    } catch (Exception e) {
                        System.out.println("None");
                    }
                    break;
                case ("delete"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    try {
                        System.out.println(table.delete(key));
                    } catch (Exception e) {
                        System.out.println("None");
                    }

            }
        }
    }
}

class HashTable {
    public Node[] table;

    public HashTable() {
        table = new Node[100000];
    }

    public void put(int key, int value) {
        if (table[key] == null) {
            Node newNode = new Node(null, value);
            table[key] = newNode;
        } else {
            Node previousNode = table[key];
            Node nextNode = table[key].getNext();
            while (nextNode != null) {
                if (previousNode.getValue() == key) {
                    previousNode.setValue(key);
                    return;
                }
                previousNode = nextNode;
                nextNode = previousNode.getNext();
            }
            Node newNode = new Node(null, value);
            previousNode.setNext(newNode);
        }
    }

    public int get(int key) {
//if (table[key] == null) {
//    throw new Exception();
//    return ;
//} e

    }

    public int delete(int key) {

    }

}

class Node {
    private Node next;
    private int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

