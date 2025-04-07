import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            System.out.println(isVPS(br.readLine()));
        }
    }

    static String isVPS(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (count < 0) {
                break;
            } else if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }

        if (count == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}