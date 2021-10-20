import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] letters = bufferedReader.readLine().split("");
        Arrays.sort(letters);
        StringBuilder stringBuilder = new StringBuilder();
        String middleLetter = null;
        for (int i = 1; i < letters.length; i++) {
            if (letters[i - 1].equals(letters[i])) {
                stringBuilder.append(letters[i]);
                i++;
            } else if (middleLetter == null) {
                middleLetter = letters[i - 1];
            }
        }

        if (stringBuilder.length() == 0) {
            System.out.println(middleLetter);
        } else {
            if (middleLetter != null) {
                System.out.println(stringBuilder.toString() + middleLetter + stringBuilder.reverse().toString());
            } else {
                System.out.println(stringBuilder.toString() + stringBuilder.reverse().toString());
            }
        }
    }
}
