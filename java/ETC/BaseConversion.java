package ETC;

public class BaseConversion {

    public String baseConversion(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int curr = n;

        while (curr > 0) {
            if (curr % k < 10)
                sb.insert(0, curr % k);
            else
                sb.insert(0, (char) (curr % k - 10 + 'A'));
            curr /= k;
        }
        return sb.toString();
    }

    public int conversionDecimal(String n, int k) {
        char[] nums = n.toCharArray();

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 'A')
                ans = ans * k + (nums[i] - 'A' + 10);
            else
                // 원래는 (10^자릿수-1) + (nums[i] - '0')인데, 어짜피 i가 nums.length - 1 만큼 도니까
                // 계산할때마다 k를 곱하면 결과는 같다.
                ans = ans * k + (nums[i] - '0');
        }
        return ans;
    }

    public String bin2Hex(String binary) {
        StringBuilder sb = new StringBuilder();
        if (binary.length() % 4 != 0) {
            for (int i = 0; i < 4 - binary.length() % 4; i++) {
                sb.append("0");
            }
        }

        String bin = sb.append(binary).toString();
        StringBuilder hex = new StringBuilder();

        for (int i = 0; i < bin.length() / 4; i++) {
            String sub = bin.substring(i * 4, i * 4 + 4);

            int sum = 0;

            for (int j = 0; j < sub.length(); j++) {
                sum += (sub.charAt(j) - '0') * (int) Math.pow(2, 4-1-j);
            }

            if (sum > 9) hex.append((char) (sum - 10 + 'A'));
            else hex.append(sum);
        }

        return hex.insert(0, "0x").toString();
    }

    public static void main(String[] args) {
        int n = 436564;
        int k = 3;

        // 직접 구현
        BaseConversion baseConversion = new BaseConversion();

        // 10진수 -> n진수
        String s = baseConversion.baseConversion(n, k);
        System.out.println("s = " + s);

        // n진수 -> 10진수
        int i = baseConversion.conversionDecimal("211", 3);
        System.out.println("i = " + i);

        // 2진수 -> 16진수(10진수 변환 없이 계산)
        String s1 = baseConversion.bin2Hex("10010");
        System.out.println("s1 = " + s1);

        // 자바 제공
        // 10진수 -> n진수
        System.out.println(Integer.toString(436564, 3));

        // n진수 -> 10진수
        System.out.println(Integer.parseInt("211", 3));

    }
}
