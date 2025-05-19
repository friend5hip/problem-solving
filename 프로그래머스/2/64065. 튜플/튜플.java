import java.util.*;

class Solution {
    public Set<Integer> solution(String s) {
        String firstParse = s.replace("{{", "").replace("}}", "").replace("},{", " ");
        String[] elements = firstParse.split(" ");
        
        Arrays.sort(elements, (a, b) -> {
            return a.length() - b.length();
        });
        
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element + " ");
        }
        
        String secondParse = sb.toString().replaceAll(",", " ");
        elements = secondParse.split(" ");
        
        Set<Integer> answer = new LinkedHashSet<>();
        for (String element : elements) {
            answer.add(Integer.parseInt(element));
        }
        
        return answer;
    }
}