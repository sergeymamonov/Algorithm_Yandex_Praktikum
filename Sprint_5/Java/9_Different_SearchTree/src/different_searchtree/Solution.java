package different_searchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int elementQuantity = Integer.parseInt(bufferedReader.readLine());
        BigInteger result = factor(2 * elementQuantity).divide(factor(elementQuantity + 1).multiply(factor(elementQuantity)));
        System.out.println(result);
    }

    private static BigInteger factor(int elementQuantity) {
        BigInteger nFactor = BigInteger.valueOf(1);
        for (int i = 1; i <= elementQuantity; i++) {
            nFactor = nFactor.multiply(BigInteger.valueOf(i));
        }
        return nFactor;
    }
}
