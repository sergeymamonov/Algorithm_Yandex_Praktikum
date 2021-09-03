//52529859
//
// Принцип работы алгоритма:
//      Алгоритм состоит из двух частей:
//          - добавления элементов в кучу;
//          - извлечения элементов из кучи.
//      После этого исходный массив ялвяется упорядоченным.
//      Куча реализована на ArrayList. Добавление элементов проихсодит в конец массива. Далее запускается механизм
//      siftUp. В котором элемент сравнивается элемент со своим родителем. Функция siftUp выполняется рекурсивно
//      до тех пор, пока либо не дойдет до вершины кучи, либо функция сравнения элементов не вернет fail.
//      После того, как все элементы добавлены в кучу, начинается процесс извлечения самого максимального элементе,
//      то есть берется вершина кучи. Каждый раз, когда удаляется вершина в куче, она заменяется заключительным
//      элементом из кучи и запускается механизм siftDown. Элемент сравнивается со своими потомками. Функция
//      выполняется рекурсивно до тех пор, пока либо не пройдет всю высоту кучи, либо пока функция сравнения
//      не вернет fail.
//      После того, как все элементы извлечены из кучи в первоначальный массив, он становится упорядоченным.
//
// Обоснование корректности:
//      Алгоритм корректен, так как в момент заполнения происзодит сравнение элементов и самый максимальный
//      элемент помещается в корень кучи. Корректное состояние кучи поддерживается и при удалении элемента из кучи.
//
// Временная сложность:
//      Временная сложность будет складываться из:
//          - помещения элемента в кучу     O(H);
//          - извлечения элемента из кучи   O(H).
//      Где H - высота кучи. Так как куча заполняется строго последовательно слева направо, то высота не превосходит logN.
//      Таких итераций будет совершено N раз, где N - количество элементов во входном массиве.
//      Таким образом итоговая сложность алгоритма будет составлять O(NlogN).
//
// Пространственная сложность:
//      Пространственная сложность в реализованном алгоритме будет складываться из:
//          - массив для кучи;
//          - рекурсивных вызовов siftUp (стек вызовов). В худшем случае произведение количество элементов в куче
//              на глубину рекурсии (высоту кучи), то есть O(NlogN);
//          - рекурсивынх вызовов siftDown (стек вызовов). В худшем случае произведение количество элементов в куче
//              на глубину рекурсии (высоту кучи), то есть O(NlogN).
//      Таким образом суммарная пространственная сложность будет составлять O(NlogN), где N - количество элементов
//      во входном массиве.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int participantQuantity = Integer.parseInt(bufferedReader.readLine());
        Participant[] participants = new Participant[participantQuantity];
        for (int i = 0; i < participantQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String login = stringTokenizer.nextToken();
            int solvedProblems = Integer.parseInt(stringTokenizer.nextToken());
            int penalty = Integer.parseInt(stringTokenizer.nextToken());
            participants[i] = new Participant(login, solvedProblems, penalty);
        }

        heapSort(participants);
        printResult(participants);
    }

    public static void heapSort(Participant[] participants) {
        ArrayList<Participant> heap = new ArrayList<>();

        for (Participant participant : participants) {
            heapAdd(heap, participant);
        }

        for (int j = 0; j < participants.length; j++) {
            participants[j] = getMaxPriority(heap);
        }
    }

    private static void printResult(Participant[] participants) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Participant participant : participants) {
            stringBuffer.append(participant.getLogin()).append("\n");
        }
        System.out.println(stringBuffer.toString());
    }

    private static void heapAdd(ArrayList<Participant> heap, Participant key) {
        heap.add(key);
        siftUp(heap, heap.size() - 1);
    }

    private static Participant getMaxPriority(ArrayList<Participant> heap) {
        Participant result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(heap, 0);
        return result;
    }

    private static void siftUp(ArrayList<Participant> heap, int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;
        if (compare(heap.get(parentIndex), heap.get(index))) {
            swap(heap, parentIndex, index);
            siftUp(heap, parentIndex);
        }
    }

    private static void siftDown(ArrayList<Participant> heap, int index) {
        int left = 2 * index + 1;
        int right = left + 1;

        if (left >= heap.size()) {
            return;
        }

        int indexLargest;
        if (right < heap.size() && compare(heap.get(left), heap.get(right))) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }

        if (compare(heap.get(index), heap.get(indexLargest))) {
            swap(heap, index, indexLargest);
            siftDown(heap, indexLargest);
        }
    }

    private static boolean compare(Participant participant1, Participant participant2) {
        if (participant1.getSolvedProblems() < participant2.getSolvedProblems()) {
            return true;
        } else if (participant1.getSolvedProblems() > participant2.getSolvedProblems()) {
            return false;
        } else {
            if (participant1.getPenalty() > participant2.getPenalty()) {
                return true;
            } else if (participant1.getPenalty() < participant2.getPenalty()) {
                return false;
            } else {
                return participant1.getLogin().compareTo(participant2.getLogin()) > 0;
            }
        }
    }

    private static void swap(ArrayList<Participant> heap, int index1, int index2) {
        Participant tmp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, tmp);
    }
}

class Participant {
    private String login;
    private int solvedProblems;
    private int penalty;

    public Participant(String login, int solvedProblems, int penalty) {
        this.login = login;
        this.solvedProblems = solvedProblems;
        this.penalty = penalty;
    }

    public String getLogin() {
        return login;
    }

    public int getSolvedProblems() {
        return solvedProblems;
    }

    public int getPenalty() {
        return penalty;
    }
}
