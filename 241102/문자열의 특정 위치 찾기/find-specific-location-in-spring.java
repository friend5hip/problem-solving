import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        String character = st.nextToken();

        int index = str.indexOf(character);
        
        if (index == -1) {
            System.out.print("No");
        } else {
            System.out.print(index);
        }
    }
}