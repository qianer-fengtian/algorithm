package bitsearch;

import java.util.ArrayList;
import java.util.List;

public class Sample06 {

    public static void main(String[] arsgs) {
        // {0, 1, 2, 3, 4}の部分集合を考える
        final int N = 5;
        final int K = 3;

        for (int bit = (1<<K)-1; bit < (1<<N); bit = nextCombination(bit)) {
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
        }
    }

    private static int nextCombination(final int sub) {
        final int x = sub & -sub;
        final int y = sub + x;
        return (((sub & ~y)/ x) >> 1) | y;
    }
}
