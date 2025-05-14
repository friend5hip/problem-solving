import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long right = 0;
        List<Integer> gimbaps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int gimbap = Integer.parseInt(br.readLine());
            if (gimbap <= k) {
                continue;
            } else if (gimbap < k * 2) {
                gimbap -= k;
            } else {
                gimbap -= k * 2;
            }
            gimbaps.add(gimbap);
        }

        for (int gimbap : gimbaps) {
           right = Math.max(right, gimbap);
        }

        // N개의 김밥을 양쪽에서 k만큼 잘라낸다. (2k 만큼 자를 수 없으면 k만큼만 잘라내고 k보다 짧으면 폐기)
        // 모두 P 길이로 일정하게 잘라낸다.
        // P 길이로 잘라낸 M개의 조각이 최소가 되는 P를 구한다.
        long left = 1;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < gimbaps.size(); i++) {
                if (gimbaps.get(i) >= mid) {
                    count += gimbaps.get(i) / mid;
                }
            }
            // m보다 적게 잘리면
            if (count >= m) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer != 0 ? answer : "-1");
    }
}