package fullsearch;

import java.util.Scanner;

public class ABC150_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final String S = sc.next();

        int cnt = 0;

        for (int i = 2; i < N; i++) {
            if (S.charAt(i-2) == 'A' && S.charAt(i-1) == 'B' && S.charAt(i) == 'C') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
