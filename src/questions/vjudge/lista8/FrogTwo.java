package questions.vjudge.lista8;

import java.util.Scanner;

public class FrogTwo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        long n, k;
        n = scanner.nextLong();
        k = scanner.nextLong();

        long[] h = new long[(int) (n + 1)];

        for (int i = 0; i < n; i++)
            h[i] = scanner.nextLong();

        long[] dp = new long[(int) (n + 1)];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0 && (i - j) <= k; j--) {
                dp[i] = Math.min(dp[i], Math.abs(h[j] - h[i]) + dp[j]);
            }
        }
        System.out.println(dp[(int) (n - 1)]);
    }
}
