package integer;

import java.util.*;

public class ABC142_D {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long A = sc.nextLong();
        final long B = sc.nextLong();

        final long g = gcd(A, B);

        final List<Map<Long, Integer>> pfs = primeFactorize(g);

        System.out.println(pfs.size() + 1);
    }

    private static long gcd(final long x, final long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    private static List<Map<Long, Integer>> primeFactorize(long n) {
        final List<Map<Long, Integer>> res = new ArrayList<>();
        for (long a = 2; a*a <= n; a++) {
            if (n % a != 0) continue;
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
