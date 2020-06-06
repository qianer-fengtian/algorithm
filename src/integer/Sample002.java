package integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 約数列挙
 */
public class Sample002 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();

        final List<Long> divisors = enumDivisors(n);

        System.out.println(divisors);
    }

    private static List<Long> enumDivisors(final long n) {
        final List<Long> res = new ArrayList<>();

        for (long i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                res.add(i);
                if (i != n/i) {
                    res.add(n/i);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}
