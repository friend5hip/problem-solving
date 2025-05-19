import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int executionTime = 0;
        
        List<String> cache = new ArrayList<>();
        for (int i = 0; i < cities.length; i++) {
            // 캐시에 있는 경우
            String currentCity = cities[i].toLowerCase();
            if (cache.contains(currentCity)) {
                executionTime += 1;
            } else {
                executionTime += 5;
            }
            LRU(cache, cacheSize, currentCity);
        }
        
        return executionTime;
    }
    
    public static void LRU(List<String> cache, int cacheSize, String city) {
        if (cacheSize == 0) return;
        if (cache.size() < cacheSize) {
            cache.add(city);
        } else {
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
            } else {
                cache.remove(0);
                cache.add(city);
            }
        }
    }
    
}