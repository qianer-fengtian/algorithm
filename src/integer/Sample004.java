package integer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 約数の個数を求める
 */
public class Sample004 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final long n = sc.nextLong();

        final var pf = primeFactorize(n);

        long res = 1;


        System.out.println(pf);

        for (final var p : pf) {
            for (final var v: p.values()) {
                res *= v + 1;
            }
        }

        System.out.println(res);
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
