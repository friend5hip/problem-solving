import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        String word1 = st.nextToken();
        String word2 = st.nextToken();

        if (word1.length() > word2.length()) {
            System.out.println(word1 + " " + word1.length());
        } else if (word1.length() == word2.length()) {
            System.out.println("same");
        } else {
            System.out.println(word2 + " " + word2.length());
        }
    }
}