package big_number;

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
        ArrayList<Integer> arrayList = new ArrayList<>(elementQuantity);
        for (int i = 0; i < elementQuantity; i++) {
            arrayList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
//        for (int i = 1; i < arrayList.size(); i++) {
//            int numberToInsert = arrayList.get(i);
//            int j = i;
//
//            while (j > 0 && comparator(numberToInsert, arrayList.get(j - 1))) {
//                arrayList.set(j, arrayList.get(j - 1));
//                j--;
//                arrayList.set(j, numberToInsert);
//            }
//        }
        for (int min = 0; min < arrayList.size()-1; min++) {
            int least = min;
            for (int j = min + 1; j < arrayList.size(); j++) {
                if (comparator(arrayList.get(j), arrayList.get(least))) {
                    least = j;
                }
            }
            int tmp = arrayList.get(min);
            arrayList.set(min, arrayList.get(least));
            arrayList.set(least, tmp);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
    }

    private static boolean comparator(int number1, int number2) {
        String number1Str = String.valueOf(number1);
        String number2Str = String.valueOf(number2);
        int minLength = Math.min(number1Str.length(), number2Str.length());
        for (int i = 0; i < minLength; i++) {
            if (number1Str.charAt(i) < number2Str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
