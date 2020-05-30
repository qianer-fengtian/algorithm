package dfs;

import java.util.*;

/**
 * 木上のDFS
 */
public class Sample004 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 仮に頂点 0 を根とする
        final int root = 0;

        // 各頂点の根からの距離 = 深さ
        final int[] depth = new int[N];

        // 各頂点を根とした部分木のサイズ
        final int[] subtreeSize = new int[N];

        // 深さ優先探索
        dfs(graph, depth, subtreeSize, root, -1, 0);

        // 結果
        for (int v = 0; v < N; v++) {
            System.out.println(v + ": depth = " + depth[v] + ", subtree_size = " + subtreeSize[v]);
        }
    }

    private static void dfs(
            final Map<Integer, List<Integer>> graph,
            final int[] depth,
            final int[] subtreeSize,
            final int v,
            final int p,
            final int d) {
        depth[v] = d;
        for (int next : graph.get(v)) {
            // next が親だったら飛ばす
            if (v == p) {
                continue;
            }
            // v は新たに next の親となる
            dfs(graph, depth, subtreeSize, next, v, d);
        }

        // 帰りがけに部分木サイズを求める
        subtreeSize[v] = 1; // 自分自身

        for (int next : graph.get(v)) {
            if (next == p) {
                continue;
            }
            // 子のサイズを加える
            subtreeSize[v] += subtreeSize[next];
        }
    }
}
