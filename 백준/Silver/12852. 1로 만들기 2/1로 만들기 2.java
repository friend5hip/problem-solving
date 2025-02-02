import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int x;
    static int[] dp = new int[1000001];
    static int[] value = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            value[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                value[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                value[i] = i / 3;
            }

        }

        System.out.println(dp[x]);
        System.out.print(x + " ");
        while (x != 1) {
            System.out.print(value[x] + " ");
            x = value[x];
        }
    }
}
