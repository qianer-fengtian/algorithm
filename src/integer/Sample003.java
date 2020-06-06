package integer;

import java.util.*;

/**
 * 素因数分解
 */
public class Sample003 {

    public static void main(String[] args) {
        final var sc = new Scanner(System.in);

        final var n = sc.nextLong();

        final var primeFactorizedList = primeFactorize(n);

        System.out.println(primeFactorizedList);
    }

    private static List<Map<Long, Integer>> primeFactorize(long n) {
        final List<Map<Long, Integer>> res = new ArrayList<>();

        for (long i = 2; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            // n が i で割り切れると分かったときには、割れる限り割り続ける

            // 指数
            int ex = 0;
            // 割れる限り割り続ける
            while (n % i == 0) {
                ex++;
                n /= i;
            }

            res.add(Map.of(i, ex));
        }

        // 最後に残った数について
        if (n != 1) {
            res.add(Map.of(n, 1));
        }

        return res;
    }
}
