package conference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> students = new ArrayList<>();
        for (int i = 0; i < studentQuantity; i++) {
            students.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int quantity = Integer.parseInt(bufferedReader.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < studentQuantity; i++) {
            if (!map.containsKey(students.get(i))) {
                map.put(students.get(i), 1);
            } else {
                map.put(students.get(i), map.get(students.get(i)) + 1);
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < quantity; i++) {
            stringBuffer.append(list.get(i).getKey()).append(" ");
        }
        System.out.println(stringBuffer.toString());
    }
}
