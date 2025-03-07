import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] woods = new int[n]; // 나무 길이는 최대 20억
        long right = 0;
        for (int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, woods[i]);
        }

        long left = 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long totalLength = 0;
            for (int i = 0; i < woods.length; i++) {
                if (woods[i] > mid) {
                    totalLength += woods[i] - mid;
                }
            }
            if (totalLength >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
