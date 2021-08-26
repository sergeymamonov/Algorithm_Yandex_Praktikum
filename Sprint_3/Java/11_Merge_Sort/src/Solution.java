import java.util.ArrayList;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid;
        ArrayList<Integer> result = new ArrayList<>();

        while (i < mid && j < right) {
            if (arr[i] < arr[j]) {
                result.add(arr[i]);
                i++;
            } else {
                result.add(arr[j]);
                j++;
            }
        }

        while (i < mid) {
            result.add(arr[i]);
            i++;
        }

        while (j < right) {
            result.add(arr[j]);
            j++;
        }

        int[] answer = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }
        return answer;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid, right);
        
        int[] result = merge(arr, left, mid, right);
        int j = 0;
        for (int i = left; i < right; i++) {
            arr[i] = result[j++];
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