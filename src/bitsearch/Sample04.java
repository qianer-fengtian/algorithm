package bitsearch;

import java.util.Scanner;

/**
 * 部分和問題
 */
public class Sample04 {

    public static void main(String[] args){
        final Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();

        final int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        final int K = sc.nextInt();

        // 全探索
        boolean exist = false;
        for (int bit = 0; bit < (1<<N); bit++) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((bit & (1<<i)) != 0) {
                    sum += A[i];
                }
            }

            if (sum == K) {
                exist = true;
                break;
            }
        }

        System.out.println(exist ? "Yes": "No");
    }
}
