package BackTracking;

/**
 * 서로 같은 column을 가진 퀸이 존재할 수 없으므로 row만 유지해도 된다.
 *
 * 배열의 index를 row,
 * 배열의 값을 colume 으로 표현한다.
 *
 * arr가 [2, 0, 1, 3] 이면 현재 퀸의 위치는 (0, 2), (1, 0), (2, 1), (3, 3) 이다.
 */
public class NQueen {

    static int[] arr;
    static int n;
    static int count = 0;

    static void nQueen(int depth) {
        // depth가 n인건 Possibility 검사를 다 받고 퀸을 다 제대로 세웠다는 것
        if (depth == n) {
            count++;
            return;
        }

        for (int row = 0; row < n; row++) {
            // depth에 row 넣기(퀸 두기)
            arr[depth] = row;

            // row 행에 말을 놓았을 때 이상이 없는지 확인(이상이 없으면 True로 반환되서 다음 퀸 놓는 재귀를 들어간다.)
            // depth를 넣는 이유는 말을 1번까지 넣었으면 0만 조사하면 되고,
            // 2까지 넣었으면 0, 1만 조사하면 되고,
            // 3까지 넣었으면 0, 1, 2만 조사하면 되기 떄문
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    static boolean Possibility(int col) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            // 일자로 놓여져 있는것
            // 서로 같은 row를 가지고 있으면 퀸이 들어갈 수 없음
            if (arr[col] == arr[prevCol]) {
                return false;

            }
            // 대각선상에 놓여있는 경우
            // colume의 차와 row의 차가 같으면 대각선으로 놓여있는것이므로 퀸이 들어갈 수 없음
            else if (Math.abs(col - prevCol) == Math.abs(arr[col] - arr[prevCol])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
        n = 4;
        arr = new int[n];

        nQueen(0);

        System.out.println("count = " + count);

    }
}