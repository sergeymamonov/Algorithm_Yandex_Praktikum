import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();
        System.out.println(str1.length());
        System.out.println(str2.length());
        System.out.println(str1);
        System.out.println("------------");
        System.out.println(str2);
        System.out.println("------------");

        if (Math.abs(str1.length() - str2.length()) > 1) {
            System.out.println("FAIL");
            return;
        }

        int i = 0;
        int j = 0;
        boolean shift = false;

        String largest;
        String least;
        if (str1.length() != str2.length()) {
            if (str1.length() > str2.length()) {
                largest = str1;
                least = str2;
            } else {
                largest = str2;
                least = str1;
            }

            while (i < largest.length() - 1 && j < least.length() - 1) {
                if (largest.charAt(i) == least.charAt(j)) {
                    i++;
                    j++;
                } else { //find excess letter
                    i++;
                    shift = true;
                    break;
                }
            }
        } else {
            largest = str1;
            least = str2;
        }

        // strings here have equal length


        while (i < largest.length() - 1 && j < least.length() - 1) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                if (shift) {
                    System.out.println("FAIL");
                    return;
                }
                i++;
                j++;
                shift = true;
            }

//            if (Math.abs(i - j) > 1) {
//                System.out.println("i: " + i + "\tj: " + j);
//                System.out.println("FAIL_2");
//                return;
//            }
        }
        System.out.println("OK");
    }
}
