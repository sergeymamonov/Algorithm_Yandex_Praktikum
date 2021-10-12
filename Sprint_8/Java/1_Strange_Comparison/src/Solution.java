import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();

        checkStrings(str1, str2);
    }

    private static void checkStrings(String str1, String str2) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (map1.containsKey(str1.charAt(i)) && map2.containsKey(str2.charAt(i))) {
                if (map1.get(str1.charAt(i)) == str2.charAt(i) && map2.get(str2.charAt(i)) == str1.charAt(i)) {
                    continue;
                } else {
                    System.out.println("NO");
                    return;
                }
            }
            if (map1.containsKey(str1.charAt(i)) || map2.containsKey(str2.charAt(i))) {
                System.out.println("NO");
                return;
            }
            map1.put(str1.charAt(i), str2.charAt(i));
            map2.put(str2.charAt(i), str1.charAt(i));
        }
        System.out.println("YES");
    }
}
