package Greedy;

import java.util.*;

public class MulOrAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.next();

        char[] chars = S.toCharArray();
        int answer = 0;

        for (char c : chars) {
            if (answer == 0 || c == '0') {
                answer += Character.getNumericValue(c);
            } else {
                answer *= Character.getNumericValue(c);
            }
        }

        System.out.println("answer = " + answer);



    }
}
