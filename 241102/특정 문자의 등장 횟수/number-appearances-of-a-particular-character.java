import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int ee = 0;
        int eb = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == 'e' && str.charAt(i+1) == 'e') {
                ee++;
            }
            if (str.charAt(i) == 'e' && str.charAt(i+1) == 'b') {
                eb++;
            }
        }
        System.out.print(ee + " " + eb);
    }
}