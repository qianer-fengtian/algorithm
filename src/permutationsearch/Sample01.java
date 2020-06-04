package permutationsearch;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample01 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();

        final Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        List<List<Integer>> list = new ArrayList<>();
        perm(List.of(a), new ArrayList<>(), list);
        System.out.println(list);
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
