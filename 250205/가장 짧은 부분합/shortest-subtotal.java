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
        // 두 개의 포인터로 합을 계산
        for (int i = 1; i <= n; i++) {
            // 첫번째 포인터가 s보다 작은 경우 다음 포인터로 전진
            if (sequence[i] > s) {
                minLength = Math.min(minLength, (j+1) - i + 1);
                break;
            }
            // 더할 숫자가 남아 있고, 현재까지 합과 다음 숫자의 합이 s보다 크지 않을 경우
            // 더한 뒤 두번째 포인터 전진
            while (j + 1 <= n && !(sum + sequence[j + 1] >= s)) {
                sum += sequence[j + 1];
                j++;
            }
            // 최소 길이를 계산
            minLength = Math.min(minLength, (j+1) - i + 1);
            // 첫번째 포인터의 숫자를 제외
            sum -= sequence[i];
        }

        System.out.println(minLength == MAX_VALUE ? -1 : minLength);
    }
}
