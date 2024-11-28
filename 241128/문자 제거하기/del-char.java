import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<Character> charList = new ArrayList<>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }

        while (charList.size() != 1) {
            int index = Integer.parseInt(br.readLine());
            if (index >= charList.size()) {
                charList.remove(charList.size() - 1);
            } else {
                charList.remove(index);
            }
            for (char c : charList) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}