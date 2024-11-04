import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strAndQuery = br.readLine();
        StringTokenizer st1 = new StringTokenizer(strAndQuery);

        String s = st1.nextToken();
        int q = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < q; i++) {
            String query = br.readLine();
            char[] strToChars = s.toCharArray();
            StringTokenizer st2 = new StringTokenizer(query);

            int whichQuery = Integer.parseInt(st2.nextToken());
            String firstWord = st2.nextToken();
            String secondWord = st2.nextToken();

            if (whichQuery == 1) {
                int firstWordtoInt = Integer.parseInt(firstWord);
                int secondWordtoInt = Integer.parseInt(secondWord);
                char temp = ' ';
                temp = strToChars[firstWordtoInt - 1];
                strToChars[firstWordtoInt - 1] = strToChars[secondWordtoInt - 1];
                strToChars[secondWordtoInt - 1] = temp;

                s = new String(strToChars);
                System.out.println(s);
            } else if (whichQuery == 2) {
                s = s.replaceAll(firstWord, secondWord);
                System.out.println(s);
            }
        }
    }
}