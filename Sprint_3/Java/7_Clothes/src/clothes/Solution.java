package clothes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int clothesQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> clothes = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < clothesQuantity; i++) {
            clothes.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int pink = 0;
        int yellow = 0;
        int crimson = 0;
        for (Integer clothe : clothes) {
            switch (clothe) {
                case 0:
                    pink++;
                    break;
                case 1:
                    yellow++;
                    break;
                case 2:
                    crimson++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < pink; i++) {
            stringBuilder.append("0 ");
        }
        for (int i = 0; i < yellow; i++) {
            stringBuilder.append("1 ");
        }
        for (int i = 0; i < crimson; i++) {
            stringBuilder.append("2 ");
        }
        System.out.println(stringBuilder.toString());
    }
}
