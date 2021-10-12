// 54332761
//
// Принцип работы алгоритма:
//      Алгоритм основан на построении префиксного дерева и использовании динамического программирования,
//      с целью сохранения результатов о возможности перемещение по строке шпаргалке с помощью заданных слов.
//      Для этого входные слова сразу сохраняются в префиксное дерево. Далее с помощью двух указателей происходит
//      перемещение по строке шпаргалке. И проверяется подстрока длиной не более самого длинного входного слова
//      между этими указателями на соответствие входных слов в префиксном дереве.
//      Базовым случаем dp[0] будет значение истины, когда начальная позиция поиска входных слов перед словом шпаргалкой.
//      Переходом динамики будет поиск следующего слова в ячейки, содержащей true.
//      Порядок вычислений в массиве слева направо.
//      Ответом будет заключительный элемент массива.
//
// Обоснование корректности:
//      Алгоритм корректен, так как происходит сравнение всех подстрок строки шпаргалки с входными словами,
//      расположенными в префиксном дереве.
//
// Временная сложность:
//      Временная сложность будет складываться из:
//          - построения префиксного дерева, O(L), где L - суммарная длина входных слов,
//          - проверки всех подстрок (длиной не более самого длинного входного слова) строки шпаргалки в
//              префиксном дереве, O(L_longest_word * n) в среднем, где L_longest_word - длина самого длинного
//              входного слова, n - количество символов в строке шпаргалке.
//      Итоговая временная сложность будет составлять O(L + L_longest_word * n).
//
// Пространственная сложность:
//      Пространственная сложность складывается из:
//          - префиксного дерева, O(A * L), где A - мощность алфавита, L - суммарная длина входных слов,
//          - массива динамического программирования, равного длине строки шпаргалки плюс ячейка базового случая, O(L_crib).
//      Итоговая пространственная сложность будет O(A * L + L_crib).


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static TrieNode trie = new TrieNode();
    public static TrieNode currentNode;
    public static int longestWord = 0;
    public static String crib;

    public static void main(String[] args) throws IOException {
        readData();
        checkCrib();
    }

    private static void readData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        crib = bufferedReader.readLine();
        int patternsQuantity = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < patternsQuantity; i++) {
            String word = bufferedReader.readLine();
            currentNode = trie;
            trie.addWord(word);
            if (word.length() > longestWord) {
                longestWord = word.length();
            }
        }
    }

    private static void checkCrib() {
        boolean[] dp = new boolean[crib.length() + 1];
        dp[0] = true;
        for (int leftIndex = 0; leftIndex < crib.length(); leftIndex++) {
            if (dp[leftIndex]) {
                currentNode = trie;
                for (int rightIndex = leftIndex + 1; rightIndex <= crib.length(); rightIndex++) {
                    if (trie.findByLetter(crib.charAt(rightIndex - 1))) {
                        if (currentNode.isTerminated()) {
                            dp[rightIndex] = true;
                        }
                    } else {
                        break;
                    }
                    if (rightIndex - leftIndex == longestWord) {
                        break;
                    }
                }
            }
        }

        System.out.println(dp[dp.length - 1] ? "YES" : "NO");
    }
}

class TrieNode {
    private HashMap<Character, TrieNode> children;
    private boolean isTerminated;

    public TrieNode() {
        children = new HashMap<>();
        isTerminated = false;
    }

    public void addWord(String word) {
        for (char ch : word.toCharArray()) {
            if (!Solution.currentNode.children.containsKey(ch)) {
                Solution.currentNode.children.put(ch, new TrieNode());
            }
            Solution.currentNode = Solution.currentNode.children.get(ch);
        }
        Solution.currentNode.isTerminated = true;
    }

    public boolean findByLetter(char ch) {
            if (!Solution.currentNode.children.containsKey(ch)) {
                return false;
            } else {
                Solution.currentNode = Solution.currentNode.children.get(ch);
            }
        return true;
    }

    public boolean isTerminated() {
        return isTerminated;
    }
}
