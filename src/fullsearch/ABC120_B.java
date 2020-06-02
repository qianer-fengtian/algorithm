package fullsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC120_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int A = sc.nextInt();
        final int B = sc.nextInt();
        final int K = sc.nextInt();

        List<Integer> l = new ArrayList<>();
        for (int i = 1; i <= Math.min(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                l.add(i);
            }
        }

        System.out.println(l.get(l.size()-K));
    }
}
