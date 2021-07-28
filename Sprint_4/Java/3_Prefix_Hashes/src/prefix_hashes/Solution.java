package prefix_hashes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        int t = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> indexes = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(Integer.parseInt(stringTokenizer.nextToken()));
            pair.add(Integer.parseInt(stringTokenizer.nextToken()));
            indexes.add(pair);
        }
        
    }
}
