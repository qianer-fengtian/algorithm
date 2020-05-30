package dfs;

import java.util.Scanner;

public class ATC001_A {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int h = sc.nextInt();
        final int w = sc.nextInt();

        final char[][] map = new char[h][w];
        final int[] s = new int[2];
        final int[] g = new int[2];

        for (int i = 0; i < h; i++) {
            final char[] cs = sc.next().toCharArray();
            for (int j = 0; j < w; j++) {
                map[i][j] = cs[j];
                if (cs[j] == 's') {
                    s[0] = i;
                    s[1] = j;
                }
                if (cs[j] == 'g') {
                    g[0] = i;
                    g[1] = j;
                }
            }
        }

        final boolean[][] seen = new boolean[h][w];

        dfs(map, seen, h, w, s[0], s[1]);

        System.out.println(seen[g[0]][g[1]] ? "Yes" : "No");
    }

    private static void dfs(char[][] graph, boolean[][] seen, int h, int w, int vh, int vw) {
        if (vh < 0 || h <= vh || vw < 0 || w <= vw) {
            return;
        }

        if (graph[vh][vw] == '#') {
            return;
        }

        if (seen[vh][vw]) {
            return;
        }

        seen[vh][vw] = true;

        dfs(graph, seen, h, w, vh-1, vw);
        dfs(graph, seen, h, w, vh+1, vw);
        dfs(graph, seen, h, w, vh, vw-1);
        dfs(graph, seen, h, w, vh, vw+1);
    }
}
