import java.util.ArrayList;

public class Solution {
    public static int finished_idx;

    public static int siftUp(int[] heap, int idx) {
        if (idx == 1) {
            return 1;
        }

        finished_idx = idx;
        int parent_idx = idx / 2;
        if (heap[parent_idx] < heap[idx]) {
            swap(heap, parent_idx, idx);
            finished_idx = parent_idx;
            siftUp(heap, parent_idx);
        }
        return finished_idx;
    }

    private static void swap(int[] heap, int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};
        assert siftUp(sample, 5) == 1;
    }
}