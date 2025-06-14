import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dice = {
            {4, 1, 3}, // 전개도의 가로축
            {5, 2}, // 전개도의 세로축
            {6} // 전개도 상의 주사위 아랫면
    };
    static int x, y = 0;
    static int dir = 0; // 동, 남, 서, 북

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int point = 0;
        // m번 이동한다.
        // 1. 이동 방향으로 한 칸 구른다. 만약 막혀있을 경우, 반대로 이동한다.
        // 2. 해당 칸의 점수를 획득한다.
        // 3. 주사위의 아랫면의 수와 해당 칸의 수를 비교해 이동 방향을 결정한다.
        while (m-- > 0) {
            move(); // 이동한다.

            point += getScore(x, y); // 이동 후 얻을 수 있는 점수를 계산한다.

            // 다음 이동 방향을 결정
            int bottom = dice[2][0]; // 주사위 아랫면 숫자
            int cell = map[x][y]; // 현재 칸의 숫자

            if (bottom > cell) {
                dir = (dir + 1) % 4;
            } else if (bottom < cell) {
                dir = (dir + 3) % 4;
            }
        }

        System.out.println(point);
    }

    public static void move() {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
            dir = (dir + 2) % 4;
            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        x = nx;
        y = ny;

        roll();
    }

    public static void roll() {
        int temp = dice[2][0];
        switch (dir) {
            // 동, 남, 서, 북
            case 0:
                dice[2][0] = dice[0][2]; // 아랫면
                dice[0][2] = dice[0][1];
                dice[0][1] = dice[0][0];
                dice[0][0] = temp;
                break;
            case 1:
                dice[2][0] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = dice[1][0];
                dice[1][0] = temp;
                break;
            case 2:
                dice[2][0] = dice[0][0];
                dice[0][0] = dice[0][1];
                dice[0][1] = dice[0][2];
                dice[0][2] = temp;
                break;
            case 3:
                dice[2][0] = dice[1][0];
                dice[1][0] = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = temp;
                break;
        }
    }

    static int getScore(int startX, int startY) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        int value = map[startX][startY];
        int count = 1;

        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int d = 0; d < 4; d++) {
                int newX = currentX + dx[d];
                int newY = currentY + dy[d];

                if (newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
                if (visited[newX][newY]) continue;
                if (map[newX][newY] != value) continue;

                visited[newX][newY] = true;
                count++;
                queue.offer(new int[]{newX, newY});
            }
        }

        return count * value;
    }

}