import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] sequence = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && sum < s) {
                sum += sequence[j];
                j++;
            }

            if (sum >= s) {
                min = Math.min(min, j - i);
            }

            sum -= sequence[i];
        }
        
        System.out.println(min == Integer.MAX_VALUE? "0" : min);
    }
}
