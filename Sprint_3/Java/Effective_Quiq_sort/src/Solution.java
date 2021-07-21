//52196015
//
//Принцип работы алгоритма:
//    Алгоритм использует сортировку quiqsort и сравнение трех полей объектов, находящихся в массиве.
//    Сортировка quiqsort состоит из выбора элемента для сравнения (pivot), сравнения всех элементов с pivot
//    и отнесения элемента в правую или левую часть в массиве. Дополнительные еструктуры данных не используются
//    для перекладывания элементов массива, поэтому осуществляется перестановка элементов из левой части в правую (on-place).
//    Данная последовательность действий выполняется рекурсивно для каждой части массива относительно pivot,
//    который выбирается новый каждую итерацию до тех пор, пока указатели с начала и конца массива не перейдут
//    через друг друга.
//
//Обоснование корректности:
//    Алгоритм корректен, так как каждый элемент сравнивается с опорным элементом и кладется в правый или левый подмассив
//    относительно опорного элемента. Так продолжается рекурсивно до тех пор, пока длина подмассива будет равна 1 или 0.
//    Подпоследовательность единичной или нулевой длины упорядочена.
//
//Временная сложность:
//    Временная сложность алгоритма quiqsort зависит от выбора элемента для сравнения (pivot) и в худшем случае (например,
//    если массив упорядочем, а выбран крайний элемент) временная сложность будет O(N^2). Но в среднем случае
//    этот алгоритм имеет временную сложность O(NlogN). В качестве элемента для сравнения выбирается элемент, находящийся
//    на среднем месте в массиве. Сравнение полей объектов в массиве выполняется за константное время. Таким образом,
//    временная сложность алгоритма O(NlogN).
//
//Пространственная сложность:
//    Во время выполнения не создается дополнительных структур данных кроме исходного массива.
//    Пространственная Сложность O(N).

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Participant> participants = new ArrayList<>();
        StringTokenizer stringTokenizer;
        for (int i = 0; i < participantQuantity; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            participants.add(new Participant(stringTokenizer.nextToken(),
                    Integer.parseInt(stringTokenizer.nextToken()),
                    Integer.parseInt(stringTokenizer.nextToken())));
        }

        quickSort(participants, 0, participantQuantity - 1);
        StringBuffer stringBuffer = new StringBuffer("");
        for (Participant participant : participants) {
            stringBuffer.append(participant.getLogin()).append(" ").append("\n");
        }
        System.out.println(stringBuffer.toString());
    }

    public static void quickSort(ArrayList<Participant> participants, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(participants, left, right);

            quickSort(participants, left, partitionIndex - 1);
            quickSort(participants, partitionIndex + 1, right);
        }
    }

    private static int partition(ArrayList<Participant> participants, int left, int right) {
        Participant pivot = participants.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (compare(participants.get(j), pivot)) {
                i++;
                swap(participants, i, j);
            }
        }

        swap(participants, i + 1, right);

        return i + 1;
    }

    private static void swap(ArrayList<Participant> participants, int i, int j) {
        Participant swapTemp = participants.get(i);
        participants.set(i, participants.get(j));
        participants.set(j, swapTemp);
    }

    private static boolean compare(Participant left, Participant pivot) {
        if (left.getSolvedProblems() > pivot.getSolvedProblems()) {
            return true;
        } else if (left.getSolvedProblems() < pivot.getSolvedProblems()) {
            return false;
        } else {
            if (left.getPenalty() < pivot.getPenalty()) {
                return true;
            } else if (left.getPenalty() > pivot.getPenalty()) {
                return false;
            } else {
                return left.getLogin().compareTo(pivot.getLogin()) < 0;
            }
        }
    }
}
