package big_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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

        Collections.sort(arrayList, (number1, number2) -> {
            int length1 = getCountsOfDigits(number1);
            int length2 = getCountsOfDigits(number2);
            int diff = length1 - length2;
            int i = 0;
            int j = 0;
            if (diff == 0) {
                if (number1 < number2) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (diff < 0) {
                while (i < length2) {
                    if (j == length1) {
                        j = 0;
                    }
                    if (getAnyDigit(number1, j) < getAnyDigit(number2, i)) {
                        return 1;
                    } else if (getAnyDigit(number1, j) > getAnyDigit(number2, i)) {
                        return -1;
                    }
                    i++;
                    j--;
                }
            } else {
                while (i < length1) {
                    if (j == length2) {
                        j = 0;
                    }
                    if (getAnyDigit(number2, j) < getAnyDigit(number1, i)) {
                        return -1;
                    }
                    if (getAnyDigit(number2, j) > getAnyDigit(number1, i)) {
                        return 1;
                    }
                    i++;
                    j++;
                }
            }
            return 1;
        });

        StringBuffer stringBuffer = new StringBuffer("");
        for (Integer number : arrayList) {
            stringBuffer.append(number);
        }
        System.out.print(stringBuffer.toString());
    }

    private static int getCountsOfDigits(int number) {
        return (number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }

    private static int getAnyDigit(int number, int position) {
        int len = getCountsOfDigits(number);
        int n = number;
        int i = len - 1;
        int ans = 0;

        if (position >= len) {
            return ans;
        }
        while (i >= position)
        {
            ans = n % 10;
            n = n / 10;
            i--;
        }
        return ans;
    }
}
