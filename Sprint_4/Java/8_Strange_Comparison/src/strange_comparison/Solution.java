package strange_comparison;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        if (line1.length() != line2.length()) {
            System.out.println("NO");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        String symbol;
        String newSymbol;
        for (int i = 0; i < line1.length(); i++) {
            symbol = line1.substring(i, i + 1);
            if (map.containsKey(symbol)) {
                newSymbol = map.get(symbol);
                if (!newSymbol.equals(line2.substring(i, i + 1))) {
                    System.out.println("NO");
                    return;
                }
            } else {
                map.put(symbol, line2.substring(i, i + 1));
            }
        }
        System.out.println("YES");
    }
}
