package fullsearch;

import java.util.Scanner;

public class ABC144_B {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= 9; y++) {
                if (x * y == N) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
}
