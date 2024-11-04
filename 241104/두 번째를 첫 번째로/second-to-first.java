import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] strToChars = str.toCharArray();
        char thatChar = strToChars[1];

        for (int i = 0; i < strToChars.length; i++) {
            if (strToChars[i] == thatChar) {
                strToChars[i] = strToChars[0];
            }
        }
        str = new String(strToChars);

        System.out.print(str);
    }
}