import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(a, b, c));
        Collections.sort(arr);
        System.out.println(arr.get(1));
    }
}