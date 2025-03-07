import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        m = Integer.parseInt(st.nextToken()); // 맞춰야 하는 포켓몬 개수
        Map<String, String> numToName = new HashMap<>();
        Map<String, String> nameToNum = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String pokemon = br.readLine();
            numToName.put(String.valueOf(i), pokemon);
            nameToNum.put(pokemon, String.valueOf(i));
        }

        for (int i = 0; i < m; i++) {
            String problem = br.readLine();
            if (nameToNum.containsKey(problem)) {
                bw.write(nameToNum.get(problem) + "\n");
            } else if (numToName.containsKey(problem)) {
                bw.write(numToName.get(problem) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}