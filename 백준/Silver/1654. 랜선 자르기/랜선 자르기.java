import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 모두 같은 길이의 랜선 개수
        long[] cables  = new long[k];
        long right = 0;
        for (int i = 0; i < k; i++) {
            cables[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, cables[i]);
        }

        long left = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid < 1) break;
            int currentSum = 0;
            for (int i = 0; i < cables.length; i++) {
                if (cables[i] >= mid) {
                    currentSum += cables[i] / mid;
                }
            }
            if (currentSum >= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
