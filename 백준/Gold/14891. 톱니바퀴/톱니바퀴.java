import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[][] wheels;
    static int score;
    static final int CLOCK = 1, COUNTER = -1;
    static final int FIRST = 0, SECOND = 1, THIRD = 2, FOURTH = 3;

    public static void main(String[] args) throws IOException {
        // 8개의 톱니(N, S)를 가진 4개의 톱니바퀴
        // K번 회전한다.
        // 톱니바퀴를 회전시키기 전, 맞닿은 톱니의 극이 다르면 맞닿은 톱니바퀴가
        // 반대 방향으로 회전
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        wheels = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String info = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = info.charAt(j) - '0';
            }
        }

        // k번 회전한다.
        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            // 회전시키기 전, 맞닿은 톱니바퀴들의 회전 여부를 검사
            // 한 번에 회전
            List<int[]> rotateList = new ArrayList<>();
            rotateList.add(new int[]{num, dir});
            switch (num) {
                case FIRST: {
                    // 오른쪽으로 전파
                    int curDir = dir;
                    if (wheels[FIRST][2] != wheels[SECOND][6]) {
                        curDir *= -1;
                        rotateList.add(new int[]{SECOND, curDir});
                        if (wheels[SECOND][2] != wheels[THIRD][6]) {
                            curDir *= -1;
                            rotateList.add(new int[]{THIRD, curDir});
                            if (wheels[THIRD][2] != wheels[FOURTH][6]) {
                                curDir *= -1;
                                rotateList.add(new int[]{FOURTH, curDir});
                            }
                        }
                    }
                    break;
                }
                case SECOND: {
                    int curDir = dir;

                    // 왼쪽
                    if (wheels[SECOND][6] != wheels[FIRST][2]) {
                        curDir *= -1;
                        rotateList.add(new int[]{FIRST, curDir});
                    }

                    // 오른쪽
                    curDir = dir;
                    if (wheels[SECOND][2] != wheels[THIRD][6]) {
                        curDir *= -1;
                        rotateList.add(new int[]{THIRD, curDir});
                        if (wheels[THIRD][2] != wheels[FOURTH][6]) {
                            curDir *= -1;
                            rotateList.add(new int[]{FOURTH, curDir});
                        }
                    }
                    break;
                }
                case THIRD: {
                     // 왼쪽 전파
                    int curDir = dir;
                    if (wheels[THIRD][6] != wheels[SECOND][2]) {
                        curDir *= -1;
                        rotateList.add(new int[]{SECOND, curDir});
                        if (wheels[SECOND][6] != wheels[FIRST][2]) {
                            curDir *= -1;
                            rotateList.add(new int[]{FIRST, curDir});
                        }
                    }

                    // 오른쪽 전파
                    curDir = dir;
                    if (wheels[THIRD][2] != wheels[FOURTH][6]) {
                        curDir *= -1;
                        rotateList.add(new int[]{FOURTH, curDir});
                    }
                    break;
                }
                case FOURTH: {
                    // 왼쪽 전파
                    int curDir = dir;
                    if (wheels[FOURTH][6] != wheels[THIRD][2]) {
                        curDir *= -1;
                        rotateList.add(new int[]{THIRD, curDir});
                        if (wheels[THIRD][6] != wheels[SECOND][2]) {
                            curDir *= -1;
                            rotateList.add(new int[]{SECOND, curDir});
                            if (wheels[SECOND][6] != wheels[FIRST][2]) {
                                curDir *= -1;
                                rotateList.add(new int[]{FIRST, curDir});
                            }
                        }
                    }
                    break;
                }
            }
            for (int[] r : rotateList) {
                rotateWheel(r[0], r[1]);
            }
        }

        for (int i = 0; i < 4; i++) {
            if (wheels[i][0] == 1) {
                score += (1 << i);
            }
        }
        System.out.println(score);
    }

    static void rotateWheel(int num, int dir) {
        int temp;
        int[] newWheel = new int[8];
        if (dir == 1) { // 시계 방향
            temp = wheels[num][7];
            for (int i = 1; i < 8; i++) {
                newWheel[i] = wheels[num][i - 1];
            }
            newWheel[0] = temp;
        } else {
            temp = wheels[num][0];
            for (int i = 1; i < 8; i++) {
                newWheel[i - 1] = wheels[num][i];
            }
            newWheel[7] = temp;
        }
        wheels[num] = newWheel;
    }
}