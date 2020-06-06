package integer;

import java.util.Scanner;

/**
 * 素数判定
 */
public class Sample001 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextLong();

        if (isPrime(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isPrime(final long n) {
        if (n == 1) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
