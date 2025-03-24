import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] grid;
    static boolean[][] visited;
    static int answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new char[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        getCombination(0, 0);
        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] queueVisited = new boolean[5][5];
        int groupSize = 0, sCount = 0;

        // BFS 시작점 찾기
        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) {
                    queue.add(new Node(i, j));
                    queueVisited[i][j] = true;
                    break outerLoop; // 첫 번째 방문 좌표를 찾으면 바로 종료
                }
            }
        }

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            groupSize++;
            if (grid[curr.x][curr.y] == 'S') sCount++;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny] && !queueVisited[nx][ny]) {
                    queue.add(new Node(nx, ny));
                    queueVisited[nx][ny] = true;
                }
            }
        }

        // 정확히 7명이 연결되어 있고 S가 4명 이상이면 정답 증가
        if (groupSize == 7 && sCount >= 4) {
            answer++;
        }
    }

    public static void getCombination(int level, int index) {
        if (level == 7) {
            bfs();
            return;
        }

        for (int i = index; i < 25; i++) {
            visited[i / 5][i % 5] = true;
            getCombination(level + 1, i + 1);
            visited[i / 5][i % 5] = false;
        }
    }
}
