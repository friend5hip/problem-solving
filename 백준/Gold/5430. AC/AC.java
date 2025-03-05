import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb;
    static String p;
    static int t, n;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            p = br.readLine(); // 함수 p (R || D)
            n = Integer.parseInt(br.readLine());
            String sequence = br.readLine();

            if (sequence.equals("[]")) {
                deque = new ArrayDeque<>();
            } else {
                // 배열에서 불필요한 부분 제거 후 Deque에 넣기
                String replaced = sequence.replace(",", " ");
                StringBuilder sb = new StringBuilder(replaced);
                sb.deleteCharAt(0); // 첫 번째 괄호 삭제
                sb.deleteCharAt(sb.length() - 1); // 마지막 괄호 삭제
                st = new StringTokenizer(sb.toString());

                deque = new ArrayDeque<>();
                while (st.hasMoreTokens()) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            int reverseCount = 0;
            boolean errorFlag = false;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    reverseCount++;
                } else if (p.charAt(j) == 'D') {
                    if (deque.isEmpty()) {
                        errorFlag = true;
                        break;
                    } else {
                        if (reverseCount % 2 == 0) {
                            deque.removeFirst();
                        } else {
                            deque.removeLast();
                        }
                    }
                }
            }

            if (errorFlag) {
                if (i == t-1) {
                    bw.write("error");
                } else {
                    bw.write("error\n");
                }
            } else {
                bw.write("[");
                if (reverseCount % 2 != 0) {
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollLast() + (deque.isEmpty() ? "" : ","));
                    }
                } else {
                    while (!deque.isEmpty()) {
                        bw.write(deque.pollFirst() + (deque.isEmpty() ? "" : ","));
                    }
                }
                if (i == t - 1) {
                    bw.write("]");
                } else {
                    bw.write("]\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
