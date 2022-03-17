package Greedy;

public class Change {

    public static void main(String[] args) {
        int n = 1260;
        int[] coins = {500, 100, 50, 10};

        int answer = 0;

        // 500 으로 2번 나누고 260
        // 100 으로 2번 나누고 60
        // 50으로 1번 나누고 10
        // 10으로 1번 나누고 0

        for(int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            answer += (n / coin);
            n %= coin;
        }

        System.out.println("answer = " + answer);

    }

}
