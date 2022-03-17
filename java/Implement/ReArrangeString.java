package Implement;

import java.util.*;

public class ReArrangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] S = sc.nextLine().split("");

        List<String> alpha = new ArrayList();
        int sum = 0;

        for (String s : S) {
            if (s.matches("[A-Za-z]")) {
                alpha.add(s);
            } else {
                sum += Integer.parseInt(s);
            }
        }

        Collections.sort(alpha);

        for (String s : alpha) {
            System.out.print(s);
        }

        System.out.print(sum);
    }
}
