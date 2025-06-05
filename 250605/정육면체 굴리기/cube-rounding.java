import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, x, y, k;
    static int[] dx = {0, 0, 0, -1, 1}; // 동, 서, 북, 남
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] map;
    static int[] dice = {0, 0, 0, 0, 0, 0, 0}; // 1-based, 윗면, 북, 동, 서, 남, 아랫면를 의미

    public static void main(String[] args) throws IOException {
        // 지도 상(n x m)에서 주사위를 움직인다.
        // 주사위의 초기 상태는 윗면이 1, 동쪽이 3을 바라보고 있고, (x, y)에서 시작한다.
        // 주사위의 모든 면에는 0이 적혀있다.
        // 주사위를 굴리면 지도 상의 칸 숫자가 바닥면에 복사되며, 지도 숫자는 0이 된다.
        // 이동 명령이 k번 주어지면, 이동할 때의 주사위 상단에 적힌 숫자를 출력한다.
        // 명령은 방향으로 주어진다. 동서남북 -> 1243
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 명령 수행 횟수

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
//            System.out.println("nextDir: " + dir);
            move(dir);
        }
    }

    // dir는 0~3
    public static void roll(int nextDir) {
        // 방향에 따라 굴렀을 때의 면의 숫자가 달라진다.
        int temp = dice[1];
        if (nextDir == 1) { // 동
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = temp;
        } else if (nextDir == 2) { // 서
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (nextDir == 3) { // 북
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        } else if (nextDir == 4) { // 남
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
    }

    public static void move(int nextDir) {
        int nx = x + dx[nextDir];
        int ny = y + dy[nextDir];
//        System.out.println("coords: " + nx + " " + ny);

        // 범위를 넘어가면 명령을 무시한다.
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
            return;
        }

        // 주사위가 다음 방향으로 구른다.
        roll(nextDir);

        // 굴렸을 때, 이동한 칸의 수가 0이면 주사위 바닥면에 있는 수가 복사된다.
        if (map[nx][ny] == 0) {
            map[nx][ny] = dice[6];
        } else {
            dice[6] = map[nx][ny];
            map[nx][ny] = 0;
        }

//        for (int i = 1; i <= 6; i++) {
//            System.out.print(dice[i] + " ");
//        }
//        System.out.println();

        // 주사위 윗면의 숫자를 출력한다.
        System.out.println(dice[1]);
        
        // 좌표를 갱신한다.
        x = nx;
        y = ny;
    }
}