import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static String originalString;
    public static HashMap<Integer, String> stringsWithIndexes = new HashMap<>();
    public static ArrayList<Integer> indexes = new ArrayList<>();
    public static int totalLength;

    public static void main(String[] args) throws IOException {
        readData();
        Collections.sort(indexes);
        char[] result = getResultString();
        printResult(result);
    }

    private static void readData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        originalString = bufferedReader.readLine();
        int insertingStringsQuantity = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < insertingStringsQuantity; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String insertString = stringTokenizer.nextToken();
            int index = Integer.parseInt(stringTokenizer.nextToken());
            stringsWithIndexes.put(index, insertString);
            indexes.add(index);
            totalLength += insertString.length();
        }
        totalLength += originalString.length();
    }

    private static char[] getResultString() {
        char[] result = new char[totalLength];
        int resultIndex = 0;
        int previousIndex = 0;
        for (int index : indexes) {
            if (stringsWithIndexes.containsKey(index)) {
                for (int j = previousIndex; j < index; j++) {
                    result[resultIndex++] = originalString.charAt(j);
                }

                previousIndex = index;

                for (int j = 0; j < stringsWithIndexes.get(index).length(); j++) {
                    result[resultIndex++] = stringsWithIndexes.get(index).charAt(j);
                }
            }
        }

        if (previousIndex != originalString.length()) {
            for (int i = previousIndex; i < originalString.length(); i++) {
                result[resultIndex++] = originalString.charAt(i);
            }
        }
        return result;
    }

    private static void printResult(char[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : result) {
            stringBuilder.append(ch);
        }

        System.out.println(stringBuilder.toString());
    }
}
