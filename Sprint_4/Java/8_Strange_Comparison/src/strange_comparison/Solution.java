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
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        char symbol1;
        char symbol2;
        char newSymbol1;
        char newSymbol2;
        for (int i = 0; i < line1.length(); i++) {
            symbol1 = line1.charAt(i);
            symbol2 = line2.charAt(i);
            if ((map1.containsKey(symbol1) && !map2.containsKey(symbol2)) || (!map1.containsKey(symbol1) && map2.containsKey(symbol2))) {
                System.out.println("NO");
                return;
            } else if (map1.containsKey(symbol1) && map2.containsKey(symbol2)) {
                newSymbol1 = map1.get(symbol1);
                newSymbol2 = map2.get(symbol2);
                if (newSymbol1 != symbol2 || newSymbol2 != symbol1) {
                    System.out.println("NO");
                    return;
                }
            } else {
                map1.put(symbol1, symbol2);
                map2.put(symbol2, symbol1);
            }
        }
        System.out.println("YES");
    }
}
