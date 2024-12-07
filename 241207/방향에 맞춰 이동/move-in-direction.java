import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 이동 횟수 N
        int N = Integer.parseInt(br.readLine());

        // N 만큼 이동
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            int[] dx = new int[]{distance, 0, -distance, 0};
            int[] dy = new int[]{0, -distance, 0, distance};
            
            switch (direction) {
                case "E": x = x + dx[0]; y = y + dy[0];
                    break;
                case "W": x = x + dx[2]; y = y + dy[2];
                    break;
                case "S": x = x + dx[1]; y = y + dy[1];
                    break;
                case "N": x = x + dx[3]; y = y + dy[3];
                    break;
                default:
                    break;
            }
        }
        System.out.print(x + " " + y);
    }
}