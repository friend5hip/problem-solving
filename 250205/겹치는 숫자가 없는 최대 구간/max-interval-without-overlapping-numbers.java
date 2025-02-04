import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] sequence = new int[100001];
    static int[] countingArray = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            while (j + 1 <= n && countingArray[sequence[j + 1]] == 0) {
                countingArray[sequence[j + 1]]++;
                j++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            countingArray[sequence[i]]--;
        }

        System.out.println(maxLength);
    }
}
