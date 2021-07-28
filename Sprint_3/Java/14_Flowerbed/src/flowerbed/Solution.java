package flowerbed;

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
        int pairQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < pairQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            addPair(pairs, start, end);
        }

        Collections.sort(pairs, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> pair1, ArrayList<Integer> pair2) {
                if (pair1.get(0) == pair2.get(0)) {
                    if (pair1.get(1) == pair2.get(1)) {
                        return 0;
                    } else {
                        return pair1.get(1) < pair2.get(1) ? -1 : 1;
                    }
                } else {
                    return pair1.get(0) < pair2.get(0) ? -1 : 1;
                }
            }
        });

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int currentStart = pairs.get(0).get(0);
        int currentEnd = pairs.get(0).get(1);
        for (ArrayList<Integer> pair : pairs) {
            if (pair.get(0) <= currentEnd) {
                if (pair.get(1) > currentEnd) {
                    currentEnd = pair.get(1);
                }
            } else {
                addPair(result, currentStart, currentEnd);
                currentStart = pair.get(0);
                currentEnd = pair.get(1);
            }
        }
        addPair(result, currentStart, currentEnd);

        for (ArrayList<Integer> pair : result) {
            System.out.println(pair.get(0) + " " + pair.get(1));
        }
    }

    private static void addPair(ArrayList<ArrayList<Integer>> pairs, int start, int end) {
        ArrayList<Integer> newPair = new ArrayList<>();
        newPair.add(start);
        newPair.add(end);
        pairs.add(newPair);
    }
}

