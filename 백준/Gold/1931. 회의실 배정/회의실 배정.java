import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
        }
        // 끝나는 시간을 기준으로 회의를 오름차순 정렬
        // 끝나는 시간이 같은 경우 시작 시간을 기준으로 내림차순 정렬
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int count = 1;
        int end = meetings[0][1];
        for (int i = 1; i < n; i++) {
            // 현재 종료 시간보다 시작이 늦는 경우 그 회의를 선택 후 종료 시간을 갱신
            int start = meetings[i][0];
            if (end <= start) {
                count++;
                end = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
