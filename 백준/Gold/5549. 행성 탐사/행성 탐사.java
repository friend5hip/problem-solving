import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        char[][] planet = new char[n + 1][m + 1];
        int[][] accSumJ = new int[n + 1][m + 1];
        int[][] accSumO = new int[n + 1][m + 1];
        int[][] accSumI = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String info = br.readLine();
            for (int j = 1; j <= m; j++) {
                planet[i][j] = info.charAt(j-1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char info = planet[i][j];
                int isJ = info == 'J' ? 1 : 0;
                int isO = info == 'O' ? 1 : 0;
                int isI = info == 'I' ? 1 : 0;
                // 현재 좌표에서 위쪽, 왼쪽을 더하고 중복으로 더한 좌상단 값을 빼준다.
                accSumJ[i][j] = accSumJ[i-1][j] + accSumJ[i][j-1] - accSumJ[i-1][j-1] + isJ;
                accSumO[i][j] = accSumO[i-1][j] + accSumO[i][j-1] - accSumO[i-1][j-1] + isO;
                accSumI[i][j] = accSumI[i-1][j] + accSumI[i][j-1] - accSumI[i-1][j-1] + isI;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());
            // 현재 좌표의 위쪽 부분합, 왼쪽 부분합을 빼주고 중복해서 뺀 값을 더해준다.
            int jCount = accSumJ[c][d] - accSumJ[a-1][d] - accSumJ[c][b-1] + accSumJ[a-1][b-1];
            int oCount = accSumO[c][d] - accSumO[a-1][d] - accSumO[c][b-1] + accSumO[a-1][b-1];
            int iCount = accSumI[c][d] - accSumI[a-1][d] - accSumI[c][b-1] + accSumI[a-1][b-1];

            sb.append(jCount + " " + oCount + " " + iCount);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}