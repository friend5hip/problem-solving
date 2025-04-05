import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < n; i++) {
            int change = Integer.parseInt(br.readLine());
            for (int coin : coins) {
                int num = change / coin;
                System.out.print(num + " ");
                change %= coin;
            }
            System.out.println();
        }
    }
}