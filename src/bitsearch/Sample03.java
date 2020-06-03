package bitsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * bit全探索
 */
public class Sample03 {

    public static void main(String[] args) {
        int n = 5;

        // {0, 1, ..., n-1}の部分集合の全探索
        for (int bit = 0; bit < (1<<n); bit++) {
            // bit で表される集合の処理を記述

            // bit の表す集合を求める
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((bit & (1<<i)) != 0) {
                    list.add(i);
                }
            }

            System.out.print(bit + ": {");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println("}");
        }
    }

    private static String b(final int bit) {
        final String s = "0000" + Integer.toBinaryString(bit);
        return s.substring(s.length() - 4);
    }
}
