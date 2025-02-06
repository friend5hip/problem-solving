import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n, x, y;
    static int[] home, festival;
    static List<int[]> convenients;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        // t개의 테스트 케이스
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            convenients = new ArrayList<>();
            q = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            home = new int[]{x, y};

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                convenients.add(new int[]{x, y});
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            festival = new int[]{x, y};

            q.add(home);
            sb.append(bfs() ? "happy\n" : "sad\n");
        }

        System.out.println(sb);
    }

    static boolean bfs() {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            // 현재 위치에서 목적지까지 갈 수 있는지 검사
            if (canReach(x, y, festival[0], festival[1])) {
                return true;
            }

            Iterator<int[]> iter = convenients.iterator();
            while (iter.hasNext()) {
                int[] next = iter.next();

                if (canReach(x, y, next[0], next[1])) {
                    q.add(next);
                    iter.remove();
                }
            }
        }
        return false;
    }

    static boolean canReach(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) <= 1000;
    }
}