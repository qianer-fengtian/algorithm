package integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * オイラー関数
 * 12 = 2^2 * 3^1
 * ℇ(12) = 12 * (1-1/2) * (1-1/3) = 4
 */
public class Sample005 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var n = sc.nextLong();

        final var pfs = primeFactorize(n);

        System.out.println(pfs);

        System.out.println(euler(pfs, n));
    }

    private static long euler(final List<Map<Long, Integer>> pfs, long n) {
        for (final var pf : pfs) {
            for (final var entry: pf.entrySet()) {
                n *= entry.getKey() - 1;
                n /= entry.getKey();
            }
        }
        return n;
    }

    private static List<Map<Long, Integer>> primeFactorize(long n) {
        final List<Map<Long, Integer>> res = new ArrayList<>();
        for (long a = 2; a * a <= n; a++) {
            if (n % a != 0) {
                continue;
            }
            int ex = 0;
            while (n % a == 0) {
                ex++;
                n /= a;
            }
            res.add(Map.of(a, ex));
        }
        if (n != 1) {
            res.add(Map.of(n, 1));
        }
        return res;
    }
}
