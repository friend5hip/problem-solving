import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0이 입력될 때까지 입력
        ArrayList<Integer> scores = new ArrayList<>();
        int i = 0;
        int score = 0;
        do {
            score = sc.nextInt();
            scores.add(score);
            i++;
        } while (score != 0);

        // 점수대별 카운트
        int[] cnt = new int[11];
        for (int j = 0; j < scores.size(); j++) {
            int tmpScore = scores.get(j);
            if (tmpScore == 100) {
                cnt[10]++;
            } else {
                tmpScore /= 10;
                cnt[tmpScore]++;
            }
        }

        // 출력
        for (int k = 10; k >= 1; k--) {
            System.out.println(k*10 + " - " + cnt[k]);
        }
    }
}