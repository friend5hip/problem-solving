import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int k, n;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        choose(1);
    }

    static void choose(int currNum) {
        // n개를 선택한 경우 결과 출력
        if (currNum == n + 1) {
            printAnswer();
            return;
        }
        
        // k 이하의 숫자를 골라 재귀 호출
        for (int select = 1; select <= k; select++) {
            answer.add(select);
            choose(currNum + 1);
            answer.remove(answer.size() - 1); 
        }
    }

    static void printAnswer() {
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}