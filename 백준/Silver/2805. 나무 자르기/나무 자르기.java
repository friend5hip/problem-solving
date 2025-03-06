import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] woods = new int[n];

        int right = 0; // 나무 길이 양수이므로 0으로 초기화
        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, woods[i]);
        }

        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 현재 절단기 높이 (오버플로우 방지)
            long currentSum = 0;
            // 현재 높이에서의 절단된 나무 길이를 구함
            for (int i = 0; i < woods.length; i++) {
                if (woods[i] > mid) {
                    currentSum += woods[i] - mid;
                }
            }
            // m보다 높으면 높이를 더 올려도 됨
            if (currentSum >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right); // 더이상 낮출 높이가 없을테니 right가 최적해
    }
}
