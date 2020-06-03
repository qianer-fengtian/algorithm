package bitsearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC147_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final Map<Integer, Map<Integer, Integer>> testimonies = new HashMap<>();
        for (int i = 0; i < N; i++) {
            final int A = sc.nextInt();
            testimonies.put(i, new HashMap<>());
            for (int j = 0; j < A; j++) {
                final int X = sc.nextInt();
                final int Y = sc.nextInt();
                testimonies.get(i).put(X-1, Y);
            }
        }

        int max = 0;
        for (int bit = 0; bit < (1<<N); bit++) {
            if (judge(N, bit, testimonies)) {
                int count = 0;
                for (int i = 0; i < N; i++) {
                    if ((bit & (1<<i)) != 0) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }

    private static boolean judge(int N, int bit, Map<Integer, Map<Integer, Integer>> testimonies) {
        // i 人目の証言を検証する
        for (int i = 0; i < N; i++) {
            // i 人目が「不親切」だったら、証言はすべて無意味
            if ((bit & (1<<i)) == 0) {
                continue;
            }

            // 証言を検証
            for (Map.Entry<Integer, Integer> testimony : testimonies.get(i).entrySet()) {
                final int k = testimony.getKey();
                final int v = testimony.getValue();

                // 証言が「親切」なのに実際は「不親切」ならダメ
                if (v == 1 && (bit & (1<<k)) == 0) {
                    return false;
                }
                // 証言が「不親切」なのに実際は「親切」ならダメ
                if (v == 0 && (bit & (1<<k)) != 0) {
                    return false;
                }
            }
        }
        // 証言がすべて一致していれば true
        return true;
    }
}
