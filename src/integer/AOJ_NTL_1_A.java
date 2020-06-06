package integer;

import java.util.*;

public class AOJ_NTL_1_A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();

        final List<Map<Long, Integer>> pfs = primeFactorize(n);

        System.out.print(n + ":");
        for (final Map<Long, Integer> pf : pfs) {
            for (final Map.Entry<Long, Integer> e : pf.entrySet()) {
                for (int i = 0; i < e.getValue(); i++) {
                    System.out.print(" " + e.getKey());
                }
            }
        }
        System.out.println();
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
            res.add(Collections.singletonMap(a, ex));
        }
        if (n != 1) {
            res.add(Collections.singletonMap(n, 1));
        }
        return res;
    }
}
