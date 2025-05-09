import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] sequence = new int[1000000];
    static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = MAX_VALUE;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sum < s) {
                sum += sequence[j];
                j++;
            }

            if (sum >= s) {
                minLength = Math.min(minLength, j - i);
            }

            sum -= sequence[i];
        }

        System.out.println(minLength == MAX_VALUE ? -1 : minLength);
    }
}
