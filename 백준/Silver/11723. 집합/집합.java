import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int x;

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int[] s = new int[21];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (operation) {
                case "add":
                    if (s[x] == 0) {
                        s[x] = 1;
                    }
                    break;
                case "remove":
                    if (s[x] == 1) {
                        s[x] = 0;
                    }
                    break;
                case "check":
                    bw.write(s[x] == 1? "1\n" : "0\n");
                    break;
                case "toggle":
                    if (s[x] == 1) {
                        s[x] = 0;
                    } else {
                        s[x] = 1;
                    }
                    break;
                case "all":
                    Arrays.fill(s, 0);
                    for (int j = 1; j <= 20; j++) {
                        s[j] = 1;
                    }
                    break;
                case "empty":
                    Arrays.fill(s, 0);
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
