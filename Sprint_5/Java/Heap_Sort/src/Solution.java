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

        int i = 0;
        while (!heap.isEmpty()) {
            participants[i] = getMaxPriority(heap);
            i++;
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
        int index = heap.size() + 1;
        heap.set(index, key);
        siftUp(heap, index);
    }

    private static Participant getMaxPriority(ArrayList<Participant> heap) {
        Participant result = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        siftDown(heap, 1);
        return result;
    }

    private static void siftUp(ArrayList<Participant> heap, int index) {
        if (index == 1) {
            return;
        }

        int parentIndex = index / 2;
        if (heap.get(parentIndex) < heap.get(index)) {

        }
    }

    private static void siftDown(ArrayList<Participant> heap, int index) {
        int left = 2 * index;
        int right = 2 * index;

        if (heap.size() < left) {
            return;
        }

        int indexLargest;
        if (right <= heap.size() && heap.get(left) < heap.get(right)) {
            indexLargest = right;
        } else {
            indexLargest = left;
        }

        if (heap.get(index) < heap.get(indexLargest)) {
            swap(heap, index, indexLargest);
            siftDown(heap, indexLargest);
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
