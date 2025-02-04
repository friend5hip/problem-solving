import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] sequence = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            while (j + 1 <= n && sum < m) {
                sum += sequence[j + 1];
                j++;
            }

            if (sum == m) {
                count++;
            }

            sum -= sequence[i];
        }

        System.out.println(count);
    }
}
