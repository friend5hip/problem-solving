import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : arr) {
            queue.add(num);
        }

        int current = queue.poll();
        List<Integer> list = new ArrayList<>();
        list.add(current);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (current != next) {
                list.add(next);
            }
            current = next;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}