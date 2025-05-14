import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] unf;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;

        int cycleCount = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (isUnion(a, b)) {
                cycleCount++;
            } else {
                union(a, b);
            }
        }

        Set<Integer> otherSets = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            otherSets.add(find(i));
        }

        System.out.println(cycleCount + (otherSets.size() - 1));
    }

    public static int find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        if (find(a) != find(b)) unf[find(a)] = unf[find(b)];
    }

    public static boolean isUnion(int a, int b) {
        return find(a) == find(b);
    }
}
