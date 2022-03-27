package ETC;

/**
 * 구간 합 빠르게 계산하기
 *
 * 한 번만 계산 해놓으면 이후 몇번의 구간 합이든 O(1)에 계산할 수 있다.
 */
public class IntervalSum {
    static int n = 5;
    static int arr[] = {10, 20, 30, 40, 50};
    static int[] prefixSum = new int[6];

    public static void main(String[] args) {
        int sumValue = 0;

        for (int i = 0; i < n; i++) {
            sumValue += arr[i];
            prefixSum[i + 1] = sumValue;
        }

        int left = 3;
        int right = 4;
        System.out.println(prefixSum[right] - prefixSum[left - 1]);

    }
}
