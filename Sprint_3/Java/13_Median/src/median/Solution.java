package median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int northIslandsQuantity = Integer.parseInt(bufferedReader.readLine());
        int southIslandsQuantity = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<Integer> northIslands = new ArrayList<>();
        for (int i = 0; i < northIslandsQuantity; i++) {
            northIslands.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        ArrayList<Integer> southIslands = new ArrayList<>();
        for (int i = 0; i < southIslandsQuantity; i++) {
            southIslands.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < northIslandsQuantity && j < southIslandsQuantity) {
            if
        }
    }
}
