import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // 생성자를 찾는다.
        int result = 0;
        // 최대 합을 뺀 최소값부터 탐색을 시작, Math.max 함수로 음수값이 나오지 않게 해준다.
        for (int i = Math.max(1, n - String.valueOf(n).length() * 9); i < n; i++) {
            int decompositionSum = i + digitSum(i); // 분해합을 계산한다.
            if (decompositionSum == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    // 각 자리수 합을 계산한다.
    static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}