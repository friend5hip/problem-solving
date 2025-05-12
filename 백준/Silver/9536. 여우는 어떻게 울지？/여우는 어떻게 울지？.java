import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<String> record = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                record.add(st.nextToken());
            }
            while (true) {
                String animal = br.readLine();
                if (animal.equals("what does the fox say?")) break;
                st = new StringTokenizer(animal);
                st.nextToken(); st.nextToken();
                String sound = st.nextToken();
                for (int j = 0; j < record.size(); j++) {
                    record.remove(sound);
                }
            }
        }

        for (String sound : record) {
            System.out.print(sound + " ");
        }
    }
}
