package dfs;

import java.util.*;

/**
 *
 */
public class Sample003 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        final int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            colors[i] =  -1;
        }


        boolean isBipartite = true;
        for (int v = 0; v < N; v++) {
            if (colors[v] != -1) {
                continue;
            }
            if (!dfs(graph, colors, v, 0)) {
                isBipartite = false;
            }
        }

        System.out.println(isBipartite ? "Yes" : "No");
    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int[] colors, int v, int curr) {
        colors[v] = curr;

        for (int next : graph.get(v)) {
            // 隣接頂点がすでに色確定していて、今の色と同じ色だったらダメ
            if (colors[next] == curr) {
                return false;
            }
            // 隣接頂点の色を変えて再帰的に探索する
            // 1回でもfalseが帰ってきたらfalse
            if (!dfs(graph, colors, next, 1 - curr)) {
                return false;
            }
        }

        return true;
    }
}
