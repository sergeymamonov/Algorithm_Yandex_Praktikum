// 55107874
//
// Принцип работы алгоритма:
//      Алгоритм основан на распаковке строки и нахождении наибольшего общего префикса (lcp) сравнением поэлементно всех строк.
//      Распаковка осуществляется с помощью двух стеков. В один кладутся числа, которые содержатся в строке,
//      во второй - буквы.
//      Распаковка осуществляется проходом по входной строке и определением является ли текущий символ буквой, числом,
//      открывающейся или закрывающейся скобкой.
//          В случае, если символ буква, то он помещается в буфер.
//          В случае, если символ число, то он помещается в стек для чисел.
//          В случае, если встретилась открывающаяся скобка, то содержимое буфера кладется на стек, буфер очищается.
//          В случае, если встретилась закрывающаяся скобка, то содержимое буфера копируется во временный буфер и
//              копируется столько раз, какое число находится на вершине числового стека.
//      Нахождение lcp осуществляется с помощью итерации по самому короткому распакованному слову. Полученная буква
//      сравнивается с символами на такой же позиции в других словах. Как только символ в каком-либо слове отличается
//      от символа на такой же позиции из самого короткого слова, то это означает что lcp не превосходит данной позиции.
//
// Обоснование корректности:
//      Алгоритм корректен, так как два стека работают синхронно при распаковке строки и действия происходят только при
//      встрече в строке открывающейся или закрывающейся скобок.
//      При поиске lcp происходит посимвольное сравнение всех строк с наикратчайшей из входного набора.
//
// Временная сложность:
//      Временная сложность будет складываться из:
//          - распаковки строки, O(L), где L - суммарная длина входных слов,
//          - нахождения lcp, O(L_shortest_word * n), где L_shortest_word - длина самого короткого
//              входного слова, n - количество входных слов.
//      Итоговая временная сложность будет составлять O(L + L_shortest_word * n).
//
// Пространственная сложность:
//      Пространственная сложность складывается из:
//          - стеков, суммарный размер которых не превосходит O(l), где l - длина входного слова,
//          - двух буферов для хранения подстрок, O(l) и O(m * substr), где m * substr - максимальное произведение
//              числа и относящейся к нему подстроки из входной строки.
//      Итоговая пространственная сложность будет O(l * m + substr).


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static String[] strings;
    public static int shortest;

    public static void main(String[] args) throws IOException {
        strings = readData();
        System.out.println(longestCommonPrefix());
    }

    private static String[] readData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int stringsQuantity = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[stringsQuantity];
        shortest = Integer.MAX_VALUE;
        for (int i = 0; i < stringsQuantity; i++) {
            strings[i] = getFullString(bufferedReader.readLine());
            if (strings[i].length() < shortest) {
                shortest = strings[i].length();
            }
        }
        return strings;
    }

    public static String getFullString(String str) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = current;
                current = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) current.append(tmp);
            } else current.append(ch);
        }
        return current.toString();
    }

    public static String longestCommonPrefix() {
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
}

