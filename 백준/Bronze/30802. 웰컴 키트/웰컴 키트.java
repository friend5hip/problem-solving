import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int minTpack = 0, maxPenPack = 0, remainder = 0;
        for (int size : sizes) {
            if (size == 0) continue;
            if (size < t) {
                minTpack++;
            } else if (size % t == 0) {
                size /= t;
                minTpack += size;
            } else {
                size /= t;
                minTpack += size;
                minTpack++;
            }
        }
        if (p < n) {
            int packs = n / p;
            remainder = n % p;
            maxPenPack = packs;
        } else if (p == n){
            maxPenPack++;
        } else {
            remainder = n % p;
        }
        System.out.println(minTpack);
        System.out.println(maxPenPack + " " + remainder);
    }
}