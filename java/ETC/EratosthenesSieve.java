package ETC;

import java.util.Arrays;

public class EratosthenesSieve {

    static int n = 1000;
    static boolean[] arr = new boolean[n + 1];

    public static void main(String[] args) {
        Arrays.fill(arr, true);

        for (int a = 2; a < Math.sqrt(n); a++) {
            if (arr[a] == true) {
                int b = 2;
                while (a * b <= n) {
                    arr[a * b] = false;
                    b += 1;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) System.out.print(i + " ");

        }

    }
}
