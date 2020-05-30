package dfs;

import java.util.*;

/**
 * s から t へ辿り着けるか
 */
public class Sample001 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();
        final int s = sc.nextInt();
        final int t = sc.nextInt();

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            graph.get(a).add(b);
        }

        boolean[] seen = new boolean[n];

        dfs(graph, seen, s);

        System.out.println(seen[t]);
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int v) {
        seen[v] = true;

        for (int next : graph.get(v)) {
            if (seen[next]) {
                continue;
            }
            dfs(graph, seen, next);
        }
    }
}
