package circles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineQuantity = Integer.parseInt(bufferedReader.readLine());
        ArrayList<String> circles = new ArrayList<>();
        HashSet<String> circlesSet = new HashSet<>();
        for (int i = 0; i < lineQuantity; i++) {
            String circle = bufferedReader.readLine();
            if (!circlesSet.contains(circle)) {
                circlesSet.add(circle);
                circles.add(circle);
            }
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (String circle : circles) {
            stringBuffer.append(circle).append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
}
