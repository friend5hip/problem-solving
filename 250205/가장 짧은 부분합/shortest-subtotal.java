import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] sequence = new int[1000001];
    static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (sequence[j + 1] > s) {
                break;
            }

            while (j + 1 <= n && !(sum + sequence[j + 1] >= s)) {
                sum += sequence[j + 1];
                j++;
            }

            minLength = Math.min(minLength, (j+1) - i + 1);

            sum -= sequence[i];
        }

        System.out.println(minLength == MAX_VALUE ? -1 : minLength);
    }
}
