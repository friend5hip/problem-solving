import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) break;
            StringBuilder sb = new StringBuilder(num);
            String reversed = String.valueOf(sb.reverse());
            System.out.println(num.equals(reversed) ? "yes" : "no");
        }
    }
}