import java.util.Arrays;
import java.util.Scanner;

public class FibonacciMemo {

    private static int fib(int n, int[] memo) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // If already computed, reuse the result
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute, store, and return
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        System.out.println("fib(" + n + ") = " + fib(n, memo));
    }
}

