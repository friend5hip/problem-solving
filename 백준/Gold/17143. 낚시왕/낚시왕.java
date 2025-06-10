import java.io.*;
import java.util.*;

public class Main {
    static int r, c, m;
    static class Shark {
        int s, d, z;
        public Shark(int s, int d, int z) {
            this.s = s; this.d = d; this.z = z;
        }
    }
    static Shark[][] map;
    static int[] dx = {0, -1, 1, 0, 0}; // 상하우좌
    static int[] dy = {0, 0, 0, 1, -1};
    static int totalSize = 0;
    static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;

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
        m = Integer.parseInt(st.nextToken()); // 상어의 수
        map = new Shark[r][c];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 이동 방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            map[r][c] = new Shark(s, d, z);
        }

        // c초 동안
        for (int i = 0; i < c; i++) {
            // 상어를 잡는다.
            catchShark(i);

            // 상어가 이동한다.
            moveSharks();

//            System.out.println("이동 후: ");
//            for (int j = 0; j < r; j++) {
//                for (int k = 0; k < c; k++) {
//                    if (map[j][k] == null) System.out.print(0 + " ");
//                    else System.out.print(map[j][k].z + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

        System.out.println(totalSize);
    }

    static void catchShark(int col) {
        for (int i = 0; i < r; i++) {
            if (map[i][col] != null) {
                totalSize += map[i][col].z;
                map[i][col] = null;
                break;
            }
        }
    }

    static void moveSharks() {
        Shark[][] temp = new Shark[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != null) {
                    Shark shark = map[i][j];
                    int x = i;
                    int y = j;
                    int s = shark.s;
                    int d = shark.d;
                    int z = shark.z;

                    // 주기 계산
                    if (d == UP || d == DOWN) {
                        s %= (2 * (r - 1));
                    } else {
                        s %= (2 * (c - 1));
                    }

                    // s번 이동하되, 경계에 부딪히면 방향 전환
                    for (int move = 0; move < s; move++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                            if (d == UP) d = DOWN;
                            else if (d == DOWN) d = UP;
                            else if (d == LEFT) d = RIGHT;
                            else if (d == RIGHT) d = LEFT;

                            nx = x + dx[d];
                            ny = y + dy[d];
                        }

                        x = nx;
                        y = ny;
                    }

                    // 가장 큰 상어만 남김
                    if (temp[x][y] == null || temp[x][y].z < z) {
                        temp[x][y] = new Shark(shark.s, d, z);
                    }
                }
            }
        }

        map = temp;
    }

}
