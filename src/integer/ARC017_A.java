package integer;

import java.util.Scanner;

public class ARC017_A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final long n = sc.nextInt();

        System.out.println(isPrime(n) ? "YES" : "NO");
    }

    private static boolean isPrime(final long n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
