import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : arr) {
            queue.add(num);
        }

        int current = queue.poll();
        List<Integer> answer = new ArrayList<>();
        answer.add(current);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (current != next) {
                answer.add(next);
            }
            current = next;
        }
        
        return answer;
    }
}