package Greedy;

import java.util.*;

public class MakeOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        // 17 / 6 = 2 ... 5
        // 16 / 2 = 8 ... 0

        // 12까지 빼야 함

        // 현재 n에서 k의 배수가 되는만큼 빼기
        // k로 나누기

        while (true) {
            int target = (n / k) * k;

            result += (n - target);
            n = target;

            if (n < k) break;

            result += 1;
            n /= k;

        }

        result += (n - 1);
        System.out.println("result = " + result);

    }


}
