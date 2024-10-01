import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr.add(a);
        }
        Collections.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        Collections.reverse(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}