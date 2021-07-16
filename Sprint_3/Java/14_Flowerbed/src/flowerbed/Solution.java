package flowerbed;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pairQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
//        ArrayList<Point> pairs = new ArrayList<>();
        for (int i = 0; i < pairQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
//            pairs.add(new Point(start, end));
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(start);
            pair.add(end);
            pairs.add(pair);
        }


        /*
        Collections.sort(pairs, Comparator.comparing(Point::getX).thenComparing(Point::getY));
        ArrayList<Point> result = new ArrayList<>();
        result.add(pairs.get(0));
        for (int i = 1; i < pairQuantity; i++) {
            if (pairs.get(i).getX() <= pairs.get(i - 1).getY()) {
                if (pairs.get(i).getY() > result.get(result.size() - 1).getY()) {
                    result.get(result.size() - 1).setLocation(result.get(result.size() - 1).getX(), pairs.get(i).getY());
                }
            } else {
                result.add(pairs.get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println((int) result.get(i).getX() + " " + (int) result.get(i).getY());
        }
    }
         */



        Collections.sort(pairs, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> pair1, ArrayList<Integer> pair2) {
                if (pair1.get(0) == pair2.get(0)) {
                    return pair1.get(1) < pair2.get(1) ? -1 : 1;
                }
                return pair1.get(0) < pair2.get(0) ? -1 : 1;
            }
        });
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(pairs.get(0));
        for (int i = 1; i < pairQuantity; i++) {
            if (pairs.get(i).get(0) <= pairs.get(i - 1).get(1)) {
                if (pairs.get(i).get(1) > result.get(result.size() - 1).get(1)) {
                    result.get(result.size() - 1).set(1, pairs.get(i).get(1));
                }
            } else {
                result.add(pairs.get(i));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).get(0) + " " + result.get(i).get(1));
        }
    }

//    private static ArrayList<ArrayList<Integer>> mergSort(ArrayList<ArrayList<Integer>> arrayList) {
//        if (arrayList.size() == 1) {
//            return arrayList;
//        }
//        left
//    }
}

