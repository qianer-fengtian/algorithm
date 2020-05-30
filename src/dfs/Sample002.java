package dfs;

import java.util.*;
import java.util.stream.Stream;

/**
 * 連結とは限らない無向グラフを与えられたとき、
 * それが何個の連結成分からなるのかを数える問題
 */
public class Sample002 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        final boolean[] seen = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (seen[i]) continue;
            dfs(graph, seen, i);
            ans++;
        }

        System.out.println(ans);
    }

    private static void dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int v) {
        seen[v] = true;

        for (int next : graph.get(v)) {
            if (seen[next]) continue;
            dfs(graph, seen, v);
        }
    }
}
