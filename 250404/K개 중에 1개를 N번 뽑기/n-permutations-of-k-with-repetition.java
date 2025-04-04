import java.util.*;

public class Main {
    static int k, n;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        getPermutation(1);
    }

    static void getPermutation(int current) {
        // n개를 넘어가면 종료하고 출력
        if (current == n + 1) {
            printAnswer();
            return;
        }
        // 1부터 k 이하의 숫자를 
        for (int select = 1; select <= k; select++) {
            answer.add(select); // 현재 숫자를 선택
            getPermutation(current + 1); // 다음 숫자를 선택
            answer.remove(answer.size() - 1); // 현재 숫자를 제거
        }
    }

    static void printAnswer() {
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}
