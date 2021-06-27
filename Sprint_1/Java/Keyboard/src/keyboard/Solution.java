//52017917

package keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int quantityButtons = Integer.parseInt(bufferedReader.readLine());
        int quantityPlayers = 2;
        ArrayList<Integer> keyboard = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < 4; j++) {
                keyboard.add(Character.digit(line.charAt(j), 10));
            }
        }
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            if (!keyboard.contains(i)) {
                continue;
            }
            int quantityNumbers = 0;
            for (Integer num : keyboard) {
                if (num == i) {
                    quantityNumbers++;
                }
            }
            if (quantityNumbers <= quantityButtons * quantityPlayers) {
                result++;
            }
        }
        System.out.println(result);
    }
}
