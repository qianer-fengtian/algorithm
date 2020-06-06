package integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC057_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();

        List<Long> divisors = new ArrayList<>();

        int ans = Integer.MAX_VALUE;

        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
               final int f = Math.max(String.valueOf(i).length(), String.valueOf(n/i).length());
               ans = Math.min(ans, f);
            }
        }

        System.out.println(ans);
    }
}
