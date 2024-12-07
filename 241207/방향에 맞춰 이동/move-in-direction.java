import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이동 횟수 N
        int N = Integer.parseInt(br.readLine());

        // N번 이동
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] parts = input.split(" ");
            // 방향, 이동 거리
            char charDirection = parts[0].charAt(0); // 방향
            int distance = Integer.parseInt(parts[1]); // 거리

            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};

            int direction = 0;
            if (charDirection == 'E') {
                direction = 0;
            } else if (charDirection == 'W') {
                direction = 1;
            } else if (charDirection == 'S') {
                direction = 2;
            } else {
                direction = 3;
            }

            x += dx[direction] * distance;
            y += dy[direction] * distance;
        }

        System.out.print(x + " " + y);
    }
}