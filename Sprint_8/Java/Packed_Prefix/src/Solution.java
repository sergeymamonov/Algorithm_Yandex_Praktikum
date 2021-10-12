import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static int shortest;

    public static void main(String[] args) throws IOException {
        String[] strings = readData();
        System.out.println(longestCommonPrefix(strings));
    }

    private static String[] readData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int stringsQuantity = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[stringsQuantity];
        shortest = Integer.MAX_VALUE;
        for (int i = 0; i < stringsQuantity; i++) {
            strings[i] = unpackString2(bufferedReader.readLine());
//            strings[i] = bufferedReader.readLine();
            if (strings[i].length() < shortest) {
                shortest = strings[i].length();
            }
        }
        return strings;
    }

//    public static String getFullString(String str) {
//        if (!str.contains("]")) {
//            return str;
//        }
//
//        int end = str.indexOf("]");
//        int start = str.substring(0, end).lastIndexOf("[");
//        int times = Integer.parseInt(str.substring(start - 1, start));
//        String subStr = str.substring(start + 1, end);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(str, 0, start - 1);
//        stringBuilder.append(subStr.repeat(times));
//        if (end + 1 < str.length()) {
//            stringBuilder.append(str.substring(end + 1));
//        }
//
//        return getFullString(stringBuilder.toString());
//    }

    public static String unpackString2(String str) {
        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int times = str.charAt(i);
                i += 2;
                while (str.charAt(i) != ']') {
                    buffer.append(str.charAt(i++));
//                    System.out.println(str.charAt(i));
                }
                for (int j = 0; j < times; j++) {
                    result.append(buffer);
                }
                buffer.setLength(0);
            }
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static String unpackString(String str) {
        if (!str.contains("]")) {
            return str;
        }

        int end = str.indexOf("]");
        int start = str.substring(0, end).lastIndexOf("[");
        int times = Integer.parseInt(str.substring(start - 1, start));
        String subStr = str.substring(start + 1, end);
        int currentIndex = 0;
//        int len = start - 1 + times * subStr.length() + str.length() - end - 1;
        char[] result = new char[start - 1 + times * subStr.length() + str.length() - end - 1];
        System.arraycopy(str.toCharArray(), 0, result, currentIndex, start - 1);
        currentIndex += start - 1;
        for (int i = 0; i < times; i++) {
            System.arraycopy(subStr.toCharArray(), 0, result, currentIndex, subStr.length());
            currentIndex += subStr.length();
        }
        if (end + 1 < str.length()) {
            System.arraycopy(str.toCharArray(), end + 1, result, currentIndex, str.substring(end + 1).length());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : result) {
            stringBuilder.append(c);
        }
//        return unpackString(stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static String longestCommonPrefix(String[] strings) {
        int maxCommonPrefix = 0;
        for (int i = 0; i < shortest; i++) {
            char currentLetter = strings[0].charAt(i);
            for (String string : strings) {
                if (string.charAt(i) != currentLetter) {
                    return strings[0].substring(0, maxCommonPrefix);
                }
            }
            maxCommonPrefix++;
        }
        return strings[0].substring(0, maxCommonPrefix);
    }

/*
    private static String longestCommonPrefix(String[] strings) {
        int maxCommonPrefix = 0;
        for (int i = 0; i < strings[0].length(); i++) {

            char currentLetter = strings[0].charAt(i);
            if (currentLetter == '[' || Character.isDigit(currentLetter)) {
                while (!Character.isLetter(strings[0].charAt(i))) {
                    strings[0] = unpackString(strings[0]);
                }
            }
            currentLetter = strings[0].charAt(i);
//            for (String string : strings) {
                for (int j = 1; j < strings.length; j++) {
                    String string = strings[j];

                try {
                    char currentLetterSecond = string.charAt(i);
                    if (currentLetterSecond == '[' || Character.isDigit(currentLetterSecond)) {
                        while (!Character.isLetter(strings[j].charAt(i))) {
                            strings[j] = unpackString(strings[j]);
                        }
                    }
                    currentLetterSecond = strings[j].charAt(i);
                    if (strings[j].charAt(i) != currentLetter) {
                        return strings[0].substring(0, maxCommonPrefix);
                    }
                } catch (Exception e) {
                    return strings[0].substring(0, maxCommonPrefix);
                }
            }
            maxCommonPrefix++;
        }
        return strings[0].substring(0, maxCommonPrefix);
    }
 */

    private static String longestCommonPrefix2(String[] strings) {
        Arrays.sort(strings);
        int shortestString = Math.min(strings[0].length(), strings[strings.length - 1].length());
        int i = 0;
        while (i < shortestString && strings[0].charAt(i) == strings[strings.length - 1].charAt(i)) {
            i++;
        }
        return strings[0].substring(0, i);
    }
}
