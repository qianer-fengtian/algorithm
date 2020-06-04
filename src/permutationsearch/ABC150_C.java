package permutationsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC150_C {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        StringBuffer p = new StringBuffer();
        for (int i = 0; i < N; i++) {
            p.append(sc.next());
        }

        StringBuffer q = new StringBuffer();
        for (int i = 0; i < N; i++) {
            q.append(sc.next());
        }

        final List<String> candidate = IntStream.rangeClosed(1, N).boxed().map(String::valueOf).collect(Collectors.toList());
        final List<List<String>> perms = new ArrayList<>();

        perm(candidate, new ArrayList<>(), perms);

        final List<String> sPerms = perms.stream()
                .map(e -> e.stream().collect(Collectors.joining("")))
                .collect(Collectors.toList());

        int a = 0;
        int b = 0;

        for (int i = 0; i < sPerms.size(); i++) {
            if (sPerms.get(i).equals(p.toString())) {
                a = i;
            }
            if (sPerms.get(i).equals(q.toString())) {
                b = i;
            }
        }

        System.out.println(Math.abs(a-b));
    }

    private static<T> void perm(List<T> candidate, List<T> perm, List<List<T>> perms) {
        if (candidate.size() == 0) {
            perms.add(perm);
        }
        for (int i = 0; i < candidate.size(); i++) {
            final List<T> c = new ArrayList<>(candidate);
            final List<T> p = new ArrayList<>(perm);
            p.add(c.get(i));
            c.remove(i);
            perm(c, p, perms);
        }
    }
}
