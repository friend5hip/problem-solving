import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer> sequence;
    static int x;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st1.nextToken());
        sequence = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while (st2.hasMoreTokens()) {
            sequence.add(Integer.parseInt(st2.nextToken()));
        }

        x = Integer.parseInt(br.readLine());

        Collections.sort(sequence);

        int left = 0;
        int right = sequence.size() - 1;
        while (left < right) {
            int i = sequence.get(left);
            int j = sequence.get(right);
            int sum = i + j;

            if (sum == x) {
                count++;
                left++;
                right--;
            } else if (sum < x) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}