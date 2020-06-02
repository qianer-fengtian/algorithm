package fullsearch;

import java.util.Scanner;

public class ABC122_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final String S = sc.next();

        int max = 0;

        for (int i = 0; i < S.length(); i++) {
            int cnt = 0;
            for (int j = i; j < S.length(); j++) {
                final char cj = S.charAt(j);
                if (!isACGT(cj)) {
                    break;
                }
                cnt++;
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    private static boolean isACGT(final char c) {
        return c == 'A' || c == 'C' || c == 'G' || c == 'T';
    }
}
