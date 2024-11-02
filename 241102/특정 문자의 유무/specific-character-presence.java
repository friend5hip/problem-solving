import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String ee = "No";
        String ab = "No";

        if (str.contains("ee")) {
            ee = "Yes";
        }
        if (str.contains("ab")) {
            ab = "Yes";
        }
        System.out.print(ee + " " + ab);
    }
}