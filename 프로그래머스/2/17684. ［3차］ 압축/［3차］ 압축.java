import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        // 인덱스 초기화
        List<String> dictionary = new ArrayList<>();
        dictionary.add("");
        for (int i = 0; i < 26; i++) {
            dictionary.add(String.valueOf((char) ('A' + i)));
        }
        
        List<Integer> index = new ArrayList<>();
        int start = 0;
        while (start < msg.length()) {
            int end = start + 1;
            // 사전에 없는 단어가 나올 때까지 문자열 길이를 늘려가며 탐색
            while (end <= msg.length() && dictionary.contains(msg.substring(start, end))) {
                end++;
            }
            
            // 사전에 있는 현재 단어까지 인덱스에 추가
            String w = msg.substring(start, end - 1);
            index.add(dictionary.indexOf(w));
            
            // 다음 글자를 추가하여 사전에 추가
            if (end <= msg.length()) {
                String wc = msg.substring(start, end);
                dictionary.add(wc);
            }
            
            start = end - 1;
        }
                    
        return index;
    }
}