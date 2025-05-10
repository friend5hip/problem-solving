import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[][] grid = new char[5][15];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(grid[i], ' ');
        }
        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                grid[i][j] = word.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (grid[j][i] == ' ') continue;
                sb.append(grid[j][i]);
            }
        }

        System.out.println(sb);
    }
}
