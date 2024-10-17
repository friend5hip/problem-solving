import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] visited = new int[n][n];
        for (int i = 0; i < m; i++) {
            String t = br.readLine();
            StringTokenizer st2 = new StringTokenizer(t);
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            visited[r-1][c-1] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
    }
}