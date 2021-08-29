public class Solution {
    public static int siftDown(int[] heap, int idx) {
        int left = 2 * idx;
        int right = 2 * idx + 1;

        if (left >= heap.length) {//у узла idx нет потомков. Необходимо выйти из метода
            return 0;
        }

//        if (heap[idx] >= heap[left] && heap[idx] >= heap[right]) {
//            return idx;
//        }

        int indexLargest = idx;
        if (right < heap.length) {
            if (heap[left] < heap[right]) {//может < в первом сравнении
                indexLargest = right;
            } else {
                indexLargest = left;
            }
        }

        int result = idx;
        if (heap[idx] < heap[indexLargest]) {
            swap(heap, idx, indexLargest);
//            result = indexLargest;
//            System.out.println("Current largest: " + indexLargest);
            result = siftDown(heap, indexLargest);
        }
//        System.out.println("10: " + heap[10]);
//        System.out.println("11: " + heap[11]);
        return Math.max(result, indexLargest);
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

    public static void main(String[] args) {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7, 9, 10, 11, 3, 2};
        System.out.println(siftDown(sample, 1));
    }
}