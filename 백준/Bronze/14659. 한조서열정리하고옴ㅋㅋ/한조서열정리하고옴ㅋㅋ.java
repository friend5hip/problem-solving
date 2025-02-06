import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, count;
    static int[] bowmans = new int[30000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            bowmans[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i + 1; j < n; j++) {
                if (bowmans[i] < bowmans[j]) {
                    break;
                } else {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}