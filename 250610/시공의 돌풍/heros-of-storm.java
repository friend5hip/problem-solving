import java.io.*;
import java.util.*;

public class Main {
    static int r, c, t;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> airPurifier;

    public static void main(String[] args) throws IOException {
        // 공기청정기는 두 행을 차지한다. (항상 1열에 설치되어 있고, 가장 윗 행과 아랫 행과 두 칸 이상 떨어짐)
        // 1초 동안,
        // 1. 미세먼지가 인접한 네 방향으로 확산(공기청정기나 칸이 없으면 확산되지 않음)
        // 확산 되는 양은 / 5, 소수점은 버림(floor), A(r,c) / 5 x (확산 방향의 개수)
        // 2. 공기 청정기가 작동한다.
        // 바람이 불면 미세먼지가 바람의 방향대로 한 칸씩 이동
        // 위쪽 1행은 반시계 방향 순환, 아래 1행은 시계 방향 순환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        airPurifier = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) airPurifier.add(new int[]{i, j});
            }
        }

        // T초가 지난 후에 남은 미세먼지 양을 구한다.
        while (t-- > 0) {
            // 미세먼지가 이동한다.
            diffuseMicroDust();

            // 공기 청정기가 작동한다.
            activateAirPurifier();
        }

        int dustLeft = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell != -1) dustLeft += cell;
            }
        }
        System.out.println(dustLeft);
    }

    static void diffuseMicroDust() {
        // 원본 배열의 복사본 생성
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 미세먼지일 경우, 확산
                if (map[i][j] > 0) {
                    int diffusionCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dx[d];
                        int nc = j + dy[d];

                        // 공기 청정기거나 칸을 벗어나면 확산이 일어나지 않음
                        if (!inRange(nr, nc) || map[nr][nc] == -1) continue;

                        // 기존의 미세먼지에 floor(map[i][j] / 5)만큼 확산됨
                        temp[nr][nc] += (int) Math.floor(map[i][j] / 5);
                        diffusionCount++;
                    }

                    // 기존의 미세먼지 칸은 map[r][c] - floor(map[r][c] / 5) * 확산된 방향의 개수가 됨
                    temp[i][j] -= ((int) Math.floor(map[i][j] / 5)) * diffusionCount;
                }
            }
        }

        map = temp; // 원본 배열에 반영
    }

    static void activateAirPurifier() {
        counterclockwise(); // 공기 청정기의 윗 부분은 반시계 방향 순환
        clockwise(); // 공기 청정기의 아랫 부분은 시계 방향 순환
    }

    static void counterclockwise() {
        int purifier = airPurifier.get(0)[0];
        int top = 0;
        int bottom = purifier;
        int left = 0;
        int right = c - 1;
        for (int i = bottom - 1; i > top; i--) map[i][left] = map[i - 1][left]; // 왼쪽 열
        for (int i = left; i < right; i++) map[top][i] = map[top][i + 1]; // 위 행
        for (int i = top; i < bottom; i++) map[i][right] = map[i + 1][right]; // 오른쪽 열
        for (int i = right; i > left; i--) map[bottom][i] = map[bottom][i - 1]; // 아래 행
        map[bottom][left + 1] = 0;
    }

    static void clockwise() {
        int purifier = airPurifier.get(1)[0];
        int top = purifier;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        for (int i = top + 1; i < bottom; i++) map[i][left] = map[i + 1][left]; // 왼쪽 열
        for (int i = left; i < right; i++) map[bottom][i] = map[bottom][i + 1]; // 아래 행
        for (int i = bottom; i > top; i--) map[i][right] = map[i - 1][right]; // 오른쪽 열
        for (int i = right; i > left; i--) map[top][i] = map[top][i - 1]; // 위 행
        map[top][left + 1] = 0;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
    }
}
