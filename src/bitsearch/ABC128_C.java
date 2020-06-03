package bitsearch;

import java.util.Scanner;

public class ABC128_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();

        final int[] s = new int[M];
        for (int i = 0; i < M; i++) {
            final int k = sc.nextInt();
            int sw = 0;
            for (int j = 0; j < k; j++) {
                sw |= (1<<(sc.nextInt()-1));
            }
            s[i] = sw;
        }

        final int[] p = new int[M];
        for (int i = 0; i < M; i++) {
            p[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int bit = 0; bit < (1<<N); bit++) {
//            System.out.println("***" + bit + "***");
            boolean lighten = true;
            for (int i = 0; i < M; i++) {
//                System.out.println(b(8, bit & s[i]) + ", " + p[i] + " = " + Integer.bitCount(bit & s[i]) % 2);
                if (Integer.bitCount(bit & s[i]) % 2 != p[i]) {
                    lighten = false;
                    break;
                }
            }

            if (lighten) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
