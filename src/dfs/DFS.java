package dfs;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DFS {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        // 超点数
        final int n = sc.nextInt();
        // 辺数
        final int m = sc.nextInt();
        // 無向グラフ
        final Map<Integer, List<Integer>> graph = new HashMap<>();

        // 無向グラフを初期化
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            // 頂点と頂点を双方向でつなぐ
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 訪問済の頂点リスト
        boolean[] seen = new boolean[n];

        dfs(graph, seen, 0);
    }

    private static void dfs(
            final Map<Integer, List<Integer>> graph,
            final boolean[] seen,
            final int v) {
        // vを訪問済とする
        seen[v] = true;

        // 行きがけ順
//        System.out.println(v);

        // vから行ける各頂点nextVについて
        for (final int next : graph.get(v)) {
            if (seen[next]) {
                // 訪問済ならスルー
                continue;
            }
            // 訪問済でないならば再帰的に探索する
            dfs(graph, seen, next);
        }

        // 帰りがけ順
        System.out.println(v);
    }
}
