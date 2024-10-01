import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            int tmp = sc.nextInt();
            if (tmp % 3 != 0) 
                flag = false;
        }
        
        if (flag == true) 
            System.out.println(1);
        else
            System.out.println(0);
    }
}