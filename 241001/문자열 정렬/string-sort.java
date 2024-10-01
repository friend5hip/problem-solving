import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] strToChars = str.toCharArray();
        Arrays.sort(strToChars);
        String sortedStr = new String(strToChars);
        System.out.println(sortedStr);
    }
}