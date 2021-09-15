public class Solution {
    public static int siftDown(int[] heap, int idx) {
        int n = heap.length;
        int left = 2 * idx;
        int right = left + 1;

        while (left < n) {
            if (heap[idx] > heap[left] && (right == n || heap[idx] > heap[right])) {
                break;
            }

            if (right == n || heap[left] > heap[right]) {
                swap(heap, idx, left);
                idx = left;
            } else {
                swap(heap, idx, right);
                idx = right;
            }

            left = 2 * idx;
            right = left + 1;
        }

        return idx;
    }

    private static void swap(int[] heap, int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
        assert siftDown(sample, 2) == 5;
    }
}