import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (str.charAt(i) == str.charAt(0)) {
                charArray[i] = str.charAt(1);
            } else if (str.charAt(i) == str.charAt(1)) {
                charArray[i] = str.charAt(0);
            }
        }
        str = new String(charArray);

        System.out.print(str);
    }
}