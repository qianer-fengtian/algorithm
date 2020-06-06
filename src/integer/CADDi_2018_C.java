package integer;

import java.util.*;

public class CADDi_2018_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long N = sc.nextLong();
        final long P = sc.nextLong();

        List<Map<Long, Integer>> pfs = primeFactorize(P);

        long ans = 1;

        for (Map<Long, Integer> pf : pfs) {
            for (Map.Entry<Long, Integer> e : pf.entrySet()) {
                for (int i = 0; i < e.getValue() / N; i++) {
                    ans *= e.getKey();
                }
            }
        }

        System.out.println(ans);
    }

    private static List<Map<Long, Integer>> primeFactorize(long n) {
        List<Map<Long, Integer>> res = new ArrayList<>();
        for (long a = 2; a*a <= n; a++) {
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
