package limited_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MyQueueSized {
    private static ArrayList<Integer> queue = new ArrayList<>();
    private static int queueLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int commandQuantity = Integer.parseInt(bufferedReader.readLine());
        queueLimit = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        String command;
        for (int i = 0; i < commandQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            command = stringTokenizer.nextToken();
            switch (command) {
                case ("push"):
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case ("pop"):
                    pop();
                    break;
                case ("peek"):
                    peek();
                    break;
                case ("size"):
                    size();
            }
        }
    }

    public static void push(int number) {
        if (queue.size() < queueLimit) {
            queue.add(0, number);
        } else {
            System.out.println("error");
        }
    }

    public static void pop() {
        if (queue.size() == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue.get(getTopIndex()));
        queue.remove(getTopIndex());
    }


    public static void peek() {
        if (queue.size() == 0) {
            System.out.println("None");
            return;
        }
        System.out.println(queue.get(getTopIndex()));
    }

    public static void size() {
        System.out.println(queue.size());
    }

    private static int getTopIndex() {
        return queue.size() - 1;
    }
}
