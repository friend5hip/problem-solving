import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] sudoku;
    static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String row = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = row.charAt(j) - '0';
            }
        }

        backtracking();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean backtracking() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    // 1~9까지 시도
                    for (int num : numbers) {
                        if (isValid(i, j, num)) {
                            sudoku[i][j] = num;
                            if (backtracking()) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    return false; // 해당 칸에 어떤 숫자도 넣을 수 없음
                }
            }
        }
        return true; // 모든 칸을 채웠음
    }

    public static boolean isValid(int row, int col, int num) {
        // 행, 열 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == num || sudoku[i][col] == num)
                return false;
        }
        
        // 3x3 정사각형 검사
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (sudoku[startRow + j][startCol + k] == num)
                    return false;
            }
        }
        return true;
    }

}