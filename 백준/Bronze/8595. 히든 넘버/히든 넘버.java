import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();

        long currentNumber = 0;
        long sum = 0;

        for (char c : word.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                sum += currentNumber;
                currentNumber = 0;
            }
        }
        sum += currentNumber;

        System.out.println(sum);
    }
}
