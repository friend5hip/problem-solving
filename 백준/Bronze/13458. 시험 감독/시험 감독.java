import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long min = 0;
        for (int i = 0; i < n; i++) {
            int current = 0;
            int minusSupervisor = a[i] - b;
            if (minusSupervisor < 0) {
                min++;
                continue;
            }
            if (minusSupervisor % c > 0) {
                current += minusSupervisor / c + 2;
            } else {
                current += minusSupervisor / c + 1;
            }
            min += current;
        }

        System.out.println(min);
    }
}
