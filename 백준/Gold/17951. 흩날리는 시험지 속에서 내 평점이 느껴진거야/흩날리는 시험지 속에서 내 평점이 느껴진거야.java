import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            left = Math.max(left, score);
            right += score;
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int group = 0;
            int currentSum = 0;
            for (int i = 0; i < n; i++) {
                currentSum += scores[i];
                if (currentSum >= mid) {
                    group++;
                    currentSum = 0;
                }
            }

            if (group >= k) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

}