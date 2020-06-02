package fullsearch;

import java.util.Scanner;

public class ABC057_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long N = sc.nextLong();

        long ans = Long.MAX_VALUE;

        for (int i = 1; i <= Math.sqrt(N); i++) {
            if ((i*(N/i)) == N) {
                ans = Math.min(ans, f(i, (int) (N/i)));
            }
        }

        System.out.println(ans);
    }

    private static int f(final int a, final int b) {
        return Math.max(String.valueOf(a).length(), String.valueOf(b).length());
    }
}
