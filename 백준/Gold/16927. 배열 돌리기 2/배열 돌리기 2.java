import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = rotateLayers();
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static int[][] rotateLayers() {
        int[][] result = new int[n][m];
        int layers = Math.min(n, m) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();
            // 위, 오른쪽, 아래, 왼쪽
            for (int j = layer; j < m - layer; j++)
                list.add(arr[layer][j]);
            for (int i = layer + 1; i < n - 1 - layer; i++)
                list.add(arr[i][m - 1 - layer]);
            for (int j = m - 1 - layer; j >= layer; j--)
                list.add(arr[n - 1 - layer][j]);
            for (int i = n - 2 - layer; i > layer; i--)
                list.add(arr[i][layer]);

            int length = list.size();
            int rotation = r % length;
            int idx = 0;

            for (int j = layer; j < m - layer; j++)
                result[layer][j] = list.get((idx++ + rotation) % length);
            for (int i = layer + 1; i < n - 1 - layer; i++)
                result[i][m - 1 - layer] = list.get((idx++ + rotation) % length);
            for (int j = m - 1 - layer; j >= layer; j--)
                result[n - 1 - layer][j] = list.get((idx++ + rotation) % length);
            for (int i = n - 2 - layer; i > layer; i--)
                result[i][layer] = list.get((idx++ + rotation) % length);
        }
        return result;
    }

}