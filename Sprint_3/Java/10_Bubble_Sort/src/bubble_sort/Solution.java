package bubble_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        bufferedReader.close();
        ArrayList<Integer> arrayList = new ArrayList<>(numberQuantity);
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < numberQuantity; i++) {
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
                print(arrayList, stringBuffer);
                break;
            }
            if (isSorted) {
                break;
            }
            print(arrayList, stringBuffer);
        }
    }

    private static void print(ArrayList<Integer> arrayList, StringBuffer stringBuffer) {
        for (Integer number : arrayList) {
            stringBuffer.append(number).append(" ");
        }
        System.out.println(stringBuffer.toString());
        stringBuffer.setLength(0);
    }
}