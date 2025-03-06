import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<String> neverHeardSet = new HashSet<>();
        Set<String> resultSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String neverHeard = br.readLine();
            neverHeardSet.add(neverHeard);
        }

        for (int i = 0; i < m; i++) {
            String neverSeen = br.readLine();
            if (neverHeardSet.contains(neverSeen)) {
                resultSet.add(neverSeen);
            }
        }

        bw.write(resultSet.size() + "\n");
        for (String name : resultSet) {
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();
    }
}
