import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int divider = 2;
        while (n >= 2) {
            if (n % divider == 0) {
                n /= divider;
                System.out.println(divider);
            } else {
                divider++;
            }
        }
    }
}