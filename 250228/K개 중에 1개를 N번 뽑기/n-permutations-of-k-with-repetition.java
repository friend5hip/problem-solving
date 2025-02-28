import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] answer = new int[n];
        StringBuilder sb = new StringBuilder();

        int count = (int) Math.pow(k, n); // 총 경우의 수

        for (int i = 0; i < count; i++) {
            int num = i;
            for (int j = 0; j < n; j++) {
                answer[j] = (num % k) + 1; // 숫자 선택
                num /= k;
            }

            // 결과 출력
            for (int j = n - 1; j >= 0; j--) {
                sb.append(answer[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
