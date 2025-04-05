import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Integer> answer = new ArrayList<>();
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line);
            int mod = 1 % n;
            int length = 1;

            while (mod != 0) {
                mod = (mod * 10 + 1) % n;
                length++;
            }
            answer.add(length);
        }

        for (int number : answer) {
            System.out.println(number);
        }
    }
}