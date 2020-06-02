package fullsearch;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class sumitrust2019_D {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final String S = sc.next();

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            final int idx = S.indexOf(String.valueOf(i));
            if (idx == -1) {
                continue;
            }
            for (int j = 0; j <= 9; j++) {
                final int jdx = S.substring(idx+1).indexOf(String.valueOf(j));
                if (jdx == -1) {
                    continue;
                }
                for (int k = idx+jdx+2; k < N; k++) {
                    set.add(String.valueOf(new char[]{S.charAt(idx), S.charAt(idx+jdx+1), S.charAt(k)}));
                }
            }
        }

        System.out.println(set.size());
    }
}
