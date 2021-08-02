package prefix_hashes;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static int a;
    private static int mod;
    private static long[] pows;
    private static long[] prefix_hashes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(bufferedReader.readLine());
        mod = Integer.parseInt(bufferedReader.readLine());
        String string = bufferedReader.readLine();
        int t = Integer.parseInt(bufferedReader.readLine());
        powBase(string.length());
        hashPrefix(string);
        StringBuffer stringBuffer = new StringBuffer("");
        StringTokenizer stringTokenizer;

        for (int i = 0; i < t; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int left = Integer.parseInt(stringTokenizer.nextToken());
            int right = Integer.parseInt(stringTokenizer.nextToken());
            stringBuffer.append(hash_substring(left, right)).append("\n");

        }
        System.out.println(stringBuffer.toString());
    }

    public static long hash_substring(int l, int r) {
        return Math.floorMod(prefix_hashes[r] - prefix_hashes[l - 1] * pows[r - (l - 1)], mod);
    }

    private static void powBase(int len) {
        pows = new long[len + 1];
        pows[0] = 1;
        for (int i = 1; i < pows.length; i++) {
            pows[i] = (pows[i - 1] * a) % mod;
        }
    }

    private static void hashPrefix(String string) {
        int len = string.length();
        prefix_hashes = new long[len + 1];
        prefix_hashes[0] = 0;
        for (int i = 1; i <= len; i++) {//было i < len
            prefix_hashes[i] = (prefix_hashes[i - 1] * a % mod + string.charAt(i - 1)) % mod;
        }
    }
}
