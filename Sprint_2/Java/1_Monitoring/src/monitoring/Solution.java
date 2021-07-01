package monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int rowsQuantity = Integer.parseInt(bufferedReader.readLine());
        int columnQuantity = Integer.parseInt(bufferedReader.readLine());

        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        for (int i = 0; i < rowsQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < columnQuantity; j++) {
                row.add(stringTokenizer.nextToken());
            }
            matrix.add(row);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < columnQuantity; j++) {
            for (int i = 0; i < rowsQuantity; i++) {
                stringBuffer.append(matrix.get(i).get(j)).append(" ");
            }
            stringBuffer.append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}
