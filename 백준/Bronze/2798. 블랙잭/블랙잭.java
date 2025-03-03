import java.io.*;
import java.util.*;

public class Main {
    static int max, currentSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        outer:
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    currentSum = cards[i] + cards[j] + cards[k];
                    if (currentSum <= m) {
                        max = Math.max(max, currentSum);
                        if (currentSum == m) {
                            break outer;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
