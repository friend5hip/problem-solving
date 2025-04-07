class Solution {
    public int solution(int hp) {
        int answer = 0;
    
        while (hp > 0) {
            int count = 0;
            if (hp >= 5) {
                hp -= 5;
                count++;
            } else if (hp >= 3) {
                hp -= 3;
                count++;
            } else {
                hp--;
                count++;
            }
            answer += count;
        }
        
        return answer;
    }
}