import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> multipleSet1 = getMultipleSet(str1);
        List<String> multipleSet2 = getMultipleSet(str2);

        // 교집합 생성
        List<String> intersection = new ArrayList<>();
        List<String> copySet1 = new ArrayList<>(multipleSet1);
        for (String element : multipleSet2) {
            if (copySet1.contains(element)) {
                intersection.add(element);
                copySet1.remove(element);
            }
        }
        
        // 합집합 생성 (다중 집합 1 + 다중 집합 2 - 교집합)
        List<String> union = new ArrayList<>(multipleSet1);
        List<String> copySet2 = new ArrayList<>(multipleSet2);
        for (String element : intersection) {
            copySet2.remove(element);
        }
        union.addAll(copySet2);
    
        if (union.size() == 0) return 65536;
        double similarity = ((double) intersection.size() / union.size()) * 65536;
        
        return (int) similarity;
    }
    
    public static List<String> getMultipleSet(String str) {
        List<String> multipleSet = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String current = str.substring(i, i+2).toLowerCase();
            if (current.charAt(0) < 'a' || current.charAt(0) > 'z' ||
                current.charAt(1) < 'a' || current.charAt(1) > 'z') {
                continue;
            }
            multipleSet.add(current);
        }
        return multipleSet;
    }
}