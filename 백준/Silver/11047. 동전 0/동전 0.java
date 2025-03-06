import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 최대한 큰 동전부터 다 넣고
        // 그 동전이 안 들어가면 빼고 하나 작은 동전을 시도
        int sum = 0;
        int count = 0;
        int i = coins.length - 1;
        while (true) {
            sum += coins[i];
            count++;
            if (sum > k) {
                sum -= coins[i];
                i--;
                count--;
            } else if (sum == k) {
                break;
            }
        }

        System.out.println(count);
    }
}
