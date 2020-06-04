package permutationsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC145_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[] x = new int[N];
        final int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        final double[][] costs = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                costs[i][j] = Math.sqrt(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j], 2));
            }
        }

        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> candidate = IntStream.range(0, N).boxed().collect(Collectors.toList());
        perm(candidate, new ArrayList<>(), perms);

        double total = 0;

        for (int i = 0; i < perms.size(); i++) {
            double sum = 0;
            final List<Integer> perm = perms.get(i);
            for (int j = 0; j < perm.size() -1; j++) {
                total += costs[perm.get(j)][perm.get(j+1)];
            }
            total += sum;
        }

        System.out.println(total / perms.size());
    }

    private static void perm(List<Integer> candidate, List<Integer> perm, List<List<Integer>> perms) {
        if (candidate.size() == 0) {
            perms.add(perm);
        }
        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> c = new ArrayList<>(candidate);
            List<Integer> p = new ArrayList<>(perm);
            p.add(c.get(i));
            c.remove(i);
            perm(c, p, perms);
        }
    }
}
