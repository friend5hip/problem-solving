import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sequence.add(Integer.parseInt(st.nextToken()));
        }
        sequence.sort((a, b) -> b - a);
        double maxNum = sequence.get(0);
        double sum = 0;
        for (int num : sequence) {
            double newNum = ((double) num / maxNum) * 100;
            sum += newNum;
        }
        System.out.println(sum / sequence.size());
    }
}