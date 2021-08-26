package big_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int elementQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<String> arrayList = new ArrayList<>(elementQuantity);
        for (int i = 0; i < elementQuantity; i++) {
            arrayList.add(stringTokenizer.nextToken());
        }

        Collections.sort(arrayList, new Comparator<Object>() {

            @Override
            public int compare(Object obj2, Object obj1) {
                String number1 = obj1.toString();
                String number2 = obj2.toString();
                return (number1 + number2).compareTo(number2 + number1);
            }
        });

        StringBuffer result = new StringBuffer();
        for (String number : arrayList) {
            result.append(number);
        }
        System.out.println(result.toString());

    }
}
