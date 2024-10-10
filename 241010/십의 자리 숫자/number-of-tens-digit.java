import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 입력 받기
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int tmp = 0;
        do {
            tmp = sc.nextInt();
            arr.add(tmp);
            i++;
        } while (tmp != 0 && i != 100);

        // 십의 자리 숫자가 몇개인지 카운트
        int[] cnt = new int[10];
        for (int j = 0; j < i; j++) {
            int tensDigit = arr.get(j);
            tensDigit /= 10;
            cnt[tensDigit]++;
        }

        // 출력
        for (int k = 1; k <= 9; k++) {
            System.out.println(k + " - " + cnt[k]);
        }
    }
}