package bracket_seq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BracketSeq {
    public static Map<String, String> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put("(", ")");
        bracketsMap.put("[", "]");
        bracketsMap.put("{", "}");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        is_correct_bracket_seq(line);
    }

    private static void is_correct_bracket_seq(String line) {
        if (line.equals("")) {
            printCorrect();
            return;
        }
        ArrayList<String> stack = new ArrayList<>();
        String[] brackets = line.split("");

        for (String bracket : brackets) {
            if (bracketsMap.containsKey(bracket)) {
                stack.add(bracket);
            } else if (bracketsMap.containsValue(bracket)) {
                if (stack.isEmpty()) {
                    printIncorrect();
                    return;
                }
                String bracketOnStackTop = stack.get(stack.size() - 1);
                if (bracketsMap.get(bracketOnStackTop).equals(bracket)) {
                    stack.remove(stack.size() - 1);
                } else {
                    printIncorrect();
                    return;
                }
            } else {
                printIncorrect();
                return;
            }
        }
        if (stack.isEmpty()) {
            printCorrect();
        } else {
            printIncorrect();
        }
    }

    private static void printIncorrect() {
        System.out.println("False");
    }

    private static void printCorrect() {
        System.out.println("True");
    }
}


//    private static boolean is_correct_bracket_seq(String line) {
//        Deque<Character> charDeque = new LinkedList<>();
//        for (char tmpChar : line.toCharArray()) {
//            if (Character.isMirrored(tmpChar))
//                if (Character.isMirrored(tmpChar + 2)) // значит левая
//                    charDeque.addFirst(tmpChar);
//                else charDeque.addLast(tmpChar);
//        }
//        if (charDeque.size() % 2 != 0) return false;
//        for (int i = 0; i < charDeque.size() / 2; i++) {
//            if ((charDeque.removeLast() - charDeque.removeFirst()) != 2) {
//                  System.out.println("False");;
//            }
//        }
//        System.out.println("True");
//    }

