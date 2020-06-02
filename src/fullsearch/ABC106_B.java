package fullsearch;

import java.util.Scanner;

public class ABC106_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                continue;
            }
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 8) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
