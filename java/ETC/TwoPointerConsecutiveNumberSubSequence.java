package ETC;

/**
 * 특정한 합을 가지는 부분 연속 수열 찾기
 */
public class TwoPointerConsecutiveNumberSubSequence {

    // 데이터의 개수 n
    static int n = 5;
    // 찾을 부분 합 m
    static int m = 5;
    static int[] arr = {1, 2, 3, 2, 5};

    public static void main(String[] args) {
        int cnt = 0;
        int intervalSum = 0;
        int end = 0;

        for (int start = 0; start < n; start++) {
            while (intervalSum < m && end < n) {
                intervalSum += arr[end];
                end += 1;
            }

            if (intervalSum == m) {
                cnt += 1;
            }

            intervalSum -= arr[start];
        }

        System.out.println(cnt);
    }
}
