package subseq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        if (isSubseq(s, t, s.length(), t.length())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean isSubseq(String s, String t, int index_S, int index_T) {
        if (index_S == 0) {
            return true;
        }
        if (index_T == 0) {
            return false;
        }

        if (s.charAt(index_S - 1) == t.charAt(index_T - 1)) {
            return isSubseq(s, t, index_S - 1, index_T - 1);
        }
        return isSubseq(s, t, index_S, index_T - 1);
    }
}
