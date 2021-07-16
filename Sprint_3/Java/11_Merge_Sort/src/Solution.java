public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int i = 0;
        int j = mid;
        int k = 0;
        int[] result = new int[arr.length];

        while (i < mid && j < arr.length) {
            if (arr[i] <= arr[j]) {
                result[k] = arr[i];
                i++;
            } else {
                result[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            result[k] = arr[i];
            k++;
            i++;
        }

        while (j < arr.length) {
            result[k] = arr[j];
            k++;
            j++;
        }
        return result;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left + 1 == right) {
            return;
        }
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);

        int i = 0;
        for (Integer number : merge(arr, left, mid, right)) {
            arr[i] = number;
            i++;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert b.equals(expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert c.equals(expected2);
    }
}