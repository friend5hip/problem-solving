import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int nth = 0;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nth++;
                if (nth == k) {
                    answer = i;
                    break;
                }
            }
        }

        System.out.println(answer == -1 ? 0 : answer);
    }
}