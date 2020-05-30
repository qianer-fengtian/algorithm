package dfs;

import java.util.Scanner;

public class AOJ_Volume11_1160 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);


        while (true) {
            final int h = sc.nextInt();
            final int w = sc.nextInt();

            if (w == 0 && h == 0) {
                return;
            }

            final int[][] c = new int[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    c[i][j] = sc.nextInt();
                }
            }

            final boolean[][] seen = new boolean[w][h];

            int ans = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (c[i][j] == 0 || seen[i][j]) {
                        continue;
                    }
                    dfs(c, seen, w, h, i, j);
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

    private static void dfs(int[][] c, boolean[][] seen, int w, int h, int x, int y) {
        if (x < 0 || w <= x || y < 0 || h <= y) {
            return;
        }

        if (c[x][y] == 0) {
            return;
        }

        if (seen[x][y]) {
            return;
        }

        seen[x][y] = true;

        dfs(c, seen, w, h, x-1, y-1);
        dfs(c, seen, w, h, x, y-1);
        dfs(c, seen, w, h, x+1, y-1);
        dfs(c, seen, w, h, x-1, y);
        dfs(c, seen, w, h, x, y);
        dfs(c, seen, w, h, x+1, y);
        dfs(c, seen, w, h, x-1, y+1);
        dfs(c, seen, w, h, x, y+1);
        dfs(c, seen, w, h, x+1, y+1);
    }
}
