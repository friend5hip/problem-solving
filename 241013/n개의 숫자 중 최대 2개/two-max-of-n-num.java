import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int toBeAdded = sc.nextInt();
            arr.add(toBeAdded);
        }
        Collections.sort(arr, Collections.reverseOrder());
        System.out.print(arr.get(0) + " " + arr.get(1));
    }
}