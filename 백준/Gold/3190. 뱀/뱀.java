import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dc = {1, 0, -1, 0};
    static Deque<int[]> snake;
    static Map<Integer, String> dirMap = new HashMap<>();
    static boolean[][] visited;
    static int dir = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine()); // 격자 크기
        int k = Integer.parseInt(br.readLine()); // 사과 개수
        map = new int[n][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r - 1][c - 1] = 1; // 1은 사과가 있음을 의미한다.
        }

        int l = Integer.parseInt(br.readLine()); // 방향 전환 횟수
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int elapsedTime = Integer.parseInt(st.nextToken()); // 시작한 뒤 흐른 시간
            String dir = st.nextToken(); // 머리의 회전 방향
            dirMap.put(elapsedTime, dir);
        }

        // 뱀의 상태를 어떤 자료구조로 담을 것인가?
        // 뱀은 방향을 바꾸면 몸이 꺾인다.
        // 사과를 먹으면 꼬리의 위치가 한 타임 줄어들지 않는다.
        // 뱀이 존재하는 칸의 위치를 큐에 넣어 유지? 앞뒤로 조작하려면 덱이 유리
        visited = new boolean[n][n];
        snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        visited[0][0] = true;

        gameStart();

        System.out.println(time);
    }

    public static void gameStart() {
        int headR = 0, headC = 0;

        while (true) {
            time++;
            int nr = headR + dr[dir];
            int nc = headC + dc[dir];
            
            // 자기 몸 혹은 격자에 부딪히면 게임 오버
            if (isGameOver(nr, nc)) break;

            // 사과를 발견하면,
            if (map[nr][nc] == 1) {
                map[nr][nc] = 0;
                snake.addFirst(new int[]{nr, nc});
                visited[nr][nc] = true;
            } else {
                snake.addFirst(new int[]{nr, nc});
                visited[nr][nc] = true;
                int[] tail = snake.pollLast();
                visited[tail[0]][tail[1]] = false;
            }

            headR = nr;
            headC = nc;

            // 시간의 흐름에 따라 방향을 전환한다.
            if (dirMap.containsKey(time)) {
                String turn = dirMap.get(time);
                turnDirection(turn);
            }
        }
    }

    static void turnDirection(String turn) {
        if (turn.equals("L")) dir = (dir + 3) % 4;
        else dir = (dir + 1) % 4;
    }

    static boolean isGameOver(int r, int c) {
        return !inRange(r, c) || visited[r][c];
    }

    static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

}
