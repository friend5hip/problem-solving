import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 입력
        String[] patients = new String[3];
        for (int i = 0; i < 3; i++) {
            patients[i] = sc.nextLine();
        }
        
        // 선별
        int[] triageRoom = new int[4];
        for(int i = 0; i < 3; i++) {
            char symptom = patients[i].charAt(0);
            int temperature = Integer.parseInt(patients[i].substring(2, 4));
            if (symptom == 'Y' && temperature > 37) {
                triageRoom[0]++;
            } else if (symptom == 'N' && temperature > 37) {
                triageRoom[1]++;
            } else if (symptom == 'Y' && temperature < 37) {
                triageRoom[2]++;
            } else {
                triageRoom[3]++;
            }
        }
        
        // 출력
        for (int j = 0; j < 4; j++) {
            System.out.print(triageRoom[j] + " ");
            if (triageRoom[0] > 2) {
                System.out.print("E");
            }
        }
    }
}