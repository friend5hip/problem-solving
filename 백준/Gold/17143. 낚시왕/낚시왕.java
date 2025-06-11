import java.io.*;
import java.util.*;

public class Main {
    static int r, c, m;
    static Shark[][] map;
    static class Shark {
        int s, d, z;
        public Shark(int s, int d, int z) {
            this.s = s; this.d = d; this.z = z;
        }
    }
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;
    static int totalZ = 0;

    public static void main(String[] args) throws IOException {
        // 칸에 상어는 최대 한 마리, 속도와 크기를 가진다.
        // 낚시왕이 C + 1에 도달하면 종료
        // 1초 동안,
        // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
        // 2. 해당 열에서 땅과 제일 가까운 상어를 잡는다.
        // 3. 상어가 이동한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new Shark[r][c];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            map[r][c] = new Shark(s, d, z);
        }

        // c초 동안
        for (int i = 0; i < c; i++) {
            // 상어를 잡는다.
            catchShark(i);
            // 상어가 움직인다.
            moveSharks();
        }

        System.out.println(totalZ);
    }

    static void catchShark(int col) {
        for (int i = 0; i < r; i++) {
            if (map[i][col] != null) {
                totalZ += map[i][col].z;
                map[i][col] = null;
                return;
            }
        }
    }

    static void moveSharks() {
        Shark[][] currentMap = new Shark[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++){
                if (map[i][j] != null) {
                    Shark current = map[i][j];
                    int[] next = getNextLoc(i, j, current.s, current.d, r, c);
                    int nr = next[0], nc = next[1], nd = next[2];
                    // 빈 칸 혹은 더 큰 경우 이동해서 잡아먹음
                    if (currentMap[nr][nc] == null || currentMap[nr][nc].z < current.z) {
                        currentMap[nr][nc] = new Shark(current.s, nd, current.z);
                    }
                }
            }
        }

        map = currentMap;
    }

    public static int[] getNextLoc(int i, int j, int speed, int dir, int R, int C) {
        int ni = i, nj = j, ndir = dir;

        if (dir == UP || dir == DOWN) {
            int cycle = 2 * (R - 1);
            int pos = (dir == DOWN) ? i : (cycle - i); // 방향에 따라 반대쪽에서 시작

            int newPos = (pos + speed) % cycle;

            if (newPos < R) {
                ni = newPos;
                ndir = DOWN;
            } else {
                ni = cycle - newPos;
                ndir = UP;
            }

        } else { // LEFT or RIGHT
            int cycle = 2 * (C - 1);
            int pos = (dir == RIGHT) ? j : (cycle - j);

            int newPos = (pos + speed) % cycle;

            if (newPos < C) {
                nj = newPos;
                ndir = RIGHT;
            } else {
                nj = cycle - newPos;
                ndir = LEFT;
            }
        }

        return new int[]{ni, nj, ndir};
    }
}