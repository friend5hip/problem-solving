import java.util.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            list.add(tmp);
        }

        int maxVal = INT_MIN;  
        int[] indexOfMaxVal = new int[1000];    // 최댓값을 저장하는 배열
        int i = 0;
        // 최댓값이 list의 첫 번째 요소가 아닐 때까지 반복한다.
        while (!(list.isEmpty()) && maxVal != list.get(0)) {
            // 최댓값 갱신
            maxVal = Collections.max(list);
            // 0부터 최댓값의 인덱스 - 1까지의 subList를 생성 
            List<Integer> subList = new ArrayList<>(list.subList(0, list.indexOf(maxVal)));
            // 최댓값의 인덱스를 저장
            indexOfMaxVal[i] = list.indexOf(maxVal) + 1;
            // list를 subList로 대체
            list.clear();
            list.addAll(subList);
            i++;
        }

        for (int j = 0; j < i; j++) {
            System.out.print(indexOfMaxVal[j] + " ");
        }
    }
}