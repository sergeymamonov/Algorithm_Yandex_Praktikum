package neighbors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRows = Integer.parseInt(bufferedReader.readLine());
        int numberOfColumns = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < numberOfColumns; j++) {
                row.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            matrix.add(row);
        }

        int element_row = Integer.parseInt(bufferedReader.readLine());
        int element_column = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> neighbors = new ArrayList<>();

        try {
            neighbors.add(matrix.get(element_row + 1).get(element_column));
        } catch (Exception ignored) {
        }

        try {
            neighbors.add(matrix.get(element_row - 1).get(element_column));
        } catch (Exception ignored) {
        }

        try {
            neighbors.add(matrix.get(element_row).get(element_column + 1));
        } catch (Exception ignored) {
        }

        try {
            neighbors.add(matrix.get(element_row).get(element_column - 1));
        } catch (Exception ignored) {
        }

        Collections.sort(neighbors);

        for (Integer neighbor : neighbors) {
            System.out.print(neighbor + " ");
        }
    }
}
