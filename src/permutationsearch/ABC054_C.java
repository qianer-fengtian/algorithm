package permutationsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC054_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();

        final boolean[][] paths = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            final int a = sc.nextInt();
            final int b = sc.nextInt();
            paths[a][b] = true;
        }

        final List<Integer> candidate = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
        final List<List<Integer>> perms = new ArrayList<>();
        perm(candidate, new ArrayList<>(), perms);

        int ans = 0;

        for (List<Integer> perm : perms.stream().filter(e -> e.get(0) == 1).collect(Collectors.toList())) {
            boolean matched = true;
//            System.out.println("[" + perm + "]");
            for (int i = 0; i < N-1; i++) {
//                System.out.println(perm.get(i) + "->" + perm.get(i+1) + " ... " + paths[perm.get(i)][perm.get(i+1)] + ", " + paths[perm.get(i+1)][perm.get(i)]);
                if (!paths[perm.get(i)][perm.get(i+1)] && !paths[perm.get(i+1)][perm.get(i)]) {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void perm(final List<Integer> candidate, final List<Integer> perm, final List<List<Integer>> perms) {
        if (candidate.size() == 0) {
            perms.add(perm);
        }
        for (int i = 0; i < candidate.size(); i++) {
            final List<Integer> c = new ArrayList<>(candidate);
            final List<Integer> p = new ArrayList<>(perm);
            p.add(candidate.get(i));
            c.remove(i);
            perm(c, p, perms);
        }
    }
}
