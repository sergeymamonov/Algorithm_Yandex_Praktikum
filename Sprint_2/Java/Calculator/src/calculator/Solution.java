// 52123445

//Принцип работы алгоритма:
//        Полученная строка разбивается на токены и анализируется - это число или математический знак.
//        - если это число, то оно кладется в стек;
//        - если это знак, то берутся два числа из стека и к ним применяется математическая операция.
//        После обработки всех токенов возвращается верхнее значение стека.
//
//Обоснование корректности:
//        алгоритм корректен, так как согласно определению обратной польской нотации при появлении в записи математического
//        знака, он применяется к нужному количеству операндов, которые предшествуют ему. Данная логика реализована в программе.
//
//Временная сложность:
//        При проходе по переданной строке вызываются функции определения число ли это и применение математической операции.
//        Каждая из этих функций работает за О(1), таким образом сложность всего алгоритма О(N).
//
//Пространственная сложность:
//        О(N), такая пространственная сложность будет в худшем случае, если все токены будут положены в стек.

package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        while (stringTokenizer.hasMoreTokens()) {
            String element = stringTokenizer.nextToken();
            if (isDigit(element)) {
                stack.push(Integer.parseInt(element));
            } else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(getOperationResult(number1, number2, element));
            }
        }
        System.out.println(stack.pop());
    }

    private static boolean isDigit(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int getOperationResult(int number1, int number2, String element) {
        int result = 0;
        switch (element) {
            case ("+"):
                result = number1 + number2;
                break;
            case ("-"):
                result = number2 - number1;
                break;
            case ("/"):
                result = Math.floorDiv(number2, number1);
                break;
            case ("*"):
                result = number1 * number2;
        }
        return result;
    }
}
