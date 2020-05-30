package dfs;

import java.util.Scanner;

public class ARC031_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int H = 10;
        final int W = 10;


        final char[][] map = new char[H][W];

        int land = 0;


        for (int i = 0; i < H; i++) {
            final char[] cs = sc.next().toCharArray();
            for (int j = 0; j < W; j++) {
                map[i][j] = cs[j];
                if (map[i][j] == 'o') {
                    land++;
                }
            }
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                final boolean[][] seen = new boolean[H][W];
                char old = map[i][j];
                map[i][j] = 'o';

                dfs(map, seen, H, W, i, j);

                int cnt = 0;
                for (int k = 0; k < H; k++) {
                    for (int l = 0; l < W; l++) {
                        if (seen[k][l]) {
                            cnt++;
                        }
                    }
                }

                if (land == cnt - 1) {
                    System.out.println("YES");
                    return;
                }

                map[i][j] = old;
            }
        }

        System.out.println("NO");
    }

    private static void dfs(char[][] graph, boolean[][] seen, int h, int w, int x, int y) {
        if (x < 0 || h <= x || y < 0 || w <= y) {
            return;
        }

        if (graph[x][y] == 'x') {
            return;
        }

        if (seen[x][y]) {
            return;
        }

        seen[x][y] = true;

        dfs(graph, seen, h, w, x-1, y);
        dfs(graph, seen, h, w, x+1, y);
        dfs(graph, seen, h, w, x, y-1);
        dfs(graph, seen, h, w, x, y+1);
    }
}
