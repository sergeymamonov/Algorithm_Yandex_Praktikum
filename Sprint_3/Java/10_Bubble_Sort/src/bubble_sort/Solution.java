package bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int elementQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        ArrayList<Integer> arrayList = new ArrayList<>(elementQuantity);
        for (int i = 0; i < elementQuantity; i++) {
            arrayList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        boolean isSortedYet = true;
        for (int i = 0; i < arrayList.size() - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    int tmp = arrayList.get(j + 1);
                    arrayList.set(j + 1, arrayList.get(j));
                    arrayList.set(j, tmp);
                    isSorted = false;
                    isSortedYet = false;
                }
            }
            if (isSortedYet) {
                for (Integer integer : arrayList) {
                    System.out.print(integer + " ");
                }
                System.out.println("");
                break;
            }
            if (isSorted) {
                break;
            }
            for (Integer integer : arrayList) {
                System.out.print(integer + " ");
            }
            System.out.println("");
        }
    }
}