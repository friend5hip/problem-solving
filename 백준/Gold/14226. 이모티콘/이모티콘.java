import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static class State {
        int screen, clipboard, time;
        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        System.out.println(bfs(s));
    }

    public static int bfs(int s) {
        Set<String> visited = new HashSet<>();
        Queue<State> queue = new ArrayDeque<>();

        visited.add("1,0");
        queue.add(new State(1, 0, 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.screen == s) return current.time; // S개가 완성되면 최소 시간을 리턴

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            String operation1 = current.screen + "," + current.screen;
            if (!visited.contains(operation1)) {
                visited.add(operation1);
                queue.add(new State(current.screen, current.screen, current.time + 1));
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            String operation2 = (current.screen + current.clipboard) + "," + current.clipboard;
            if (!visited.contains(operation2)) {
                visited.add(operation2);
                queue.add(new State((current.screen + current.clipboard), current.clipboard, current.time + 1));
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            String operation3 = current.screen - 1 + "," + current.clipboard;
            if (!visited.contains(operation3)) {
                visited.add(operation3);
                queue.add(new State(current.screen - 1, current.clipboard, current.time +  1));
            }
        }
        return -1;
    }
}
