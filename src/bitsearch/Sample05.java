package bitsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 与えられた部分集合の部分集合を列挙
 */
public class Sample05 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = 10;
        final int A = (1<<2) | (1<<3) | (1<<5) | (1<<7);

        for (int bit = A;; bit = (bit-1) & A) {
            System.out.println(b(N, bit));

            // ここに処理を記述

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if ((bit & (1<<i)) != 0) {
                    list.add(i);
                }
            }

            System.out.print(bit + ": {");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println("}");

            // 最後の 0 で break
            if (bit == 0) {
                break;
            }
        }
    }

    private static String b(final int n, final int bit) {
        final String s = "0".repeat(n) + Integer.toBinaryString(bit);
        return s.substring(s.length() - n);
    }
}
