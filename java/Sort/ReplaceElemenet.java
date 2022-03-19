package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
5 3
1 2 5 4 3
5 5 6 6 5
 */

public class ReplaceElemenet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            a[i] = b[i];
        }

        long sum = Arrays.stream(
                        Arrays.stream(a)
                                .mapToLong(Integer::intValue)
                                .toArray())
                .sum();

        System.out.println("sum = " + sum);

    }
}
