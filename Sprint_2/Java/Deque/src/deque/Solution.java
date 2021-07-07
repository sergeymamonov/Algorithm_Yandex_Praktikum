//52120578

//Принцип работы алгоритма:
//        В основе реализации дека лежит массив фиксированной длины.
//        Для работы с массивом используются два указателя:
//        - head;
//        - tail.
//        Изначально эти указатели установлены на нулевую ячейку массива.
//        При добавлении в голову элемента значение указателя head уменьшается на единицу.
//        При добавлении в хвост очереди значение указателя tail увеличивается на единицу.
//        При достижении указателя head значения 0 следующим значением будет индекс заключительной ячейки в массиве.
//        При достижении указателя tail значения, равного индексу заключительной эчейки в массиве, следующим значением будет 0
//
//Обоснование корректности:
//        При данной реализации не будет выхода за границы массива (меньше нуля, больше максимального значения),
//        так как имеются проверки для указателей.
//        Также есть проверка на заполненность массива (пустой или полный).
//
//Временная сложность:
//        Для всех операций временная сложность О(1), так как во всех методах используется взятие значение из массива,
//        которое выполняется за О(1).
//
//Пространственная сложность:
//        О(N), где N - максимальное количество элементов в деке. Дополнительных структур данных не создается.

package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int currentDequeSize;
    public static int maxDequeSize;
    public static int head = 0;
    public static int tail = 0;
    public static StringBuffer stringBuffer = new StringBuffer("");

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int commandQuantity = Integer.parseInt(bufferedReader.readLine());
        maxDequeSize = Integer.parseInt(bufferedReader.readLine());
        int value;

        int[] deque = new int[maxDequeSize];
        for (int i = 0; i < commandQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case ("push_back"):
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    push_back(value, deque);
                    break;
                case ("push_front"):
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    push_front(value, deque);
                    break;
                case ("pop_back"):
                    pop_back(deque);
                    break;
                case ("pop_front"):
                    pop_front(deque);
            }
        }
        System.out.println(stringBuffer.toString());
    }

    public static void push_back(int value, int[] deque) {
        if (isFull()) {
            return;
        }
        if (++tail == maxDequeSize) {
            tail = 0;
        }
        deque[tail] = value;
        currentDequeSize++;
    }

    public static void pop_back(int[] deque) {
        if (isEmpty()) {
            return;
        }
        int result = deque[tail];
        if (--tail < 0) {
            tail = maxDequeSize - 1;
        }
        stringBuffer.append(result + "\n");
        currentDequeSize--;
    }

    public static void push_front(int value, int[] deque) {
        if (isFull()) {
            return;
        }
        deque[head] = value;
        if (--head < 0) {
            head = maxDequeSize - 1;
        }
        currentDequeSize++;
    }

    public static void pop_front(int[] deque) {
        if (isEmpty()) {
            return;
        }
        if (++head == maxDequeSize) {
            head = 0;
        }
        stringBuffer.append(deque[head] + "\n");
        currentDequeSize--;
    }

    private static boolean isFull() {
        if (currentDequeSize == maxDequeSize) {
            stringBuffer.append("error\n");
            return true;
        }
        return false;
    }

    private static boolean isEmpty() {
        if (currentDequeSize == 0) {
            stringBuffer.append("error\n");
            return true;
        }
        return false;
    }
}
