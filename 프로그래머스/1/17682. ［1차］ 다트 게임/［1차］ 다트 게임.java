class Solution {
    public int solution(String dartResult) {
        String preprocessed = dartResult.replace("10", "!");
        char[] chars = preprocessed.toCharArray();

        int sum = 0;
        int previous = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int current = 0;

            // 1. 숫자 처리
            if (ch == '!' || Character.isDigit(ch)) {
                current = (ch == '!') ? 10 : ch - '0';

                // 다음 글자는 보너스
                char bonus = chars[i + 1];
                switch (bonus) {
                    case 'S': current = (int)Math.pow(current, 1); break;
                    case 'D': current = (int)Math.pow(current, 2); break;
                    case 'T': current = (int)Math.pow(current, 3); break;
                }
                i++; // 보너스 처리했으므로 i 증가

                // 옵션 문자 확인
                if (i + 1 < chars.length) {
                    char option = chars[i + 1];
                    if (option == '*') {
                        current *= 2;
                        sum += previous; // 이전 점수를 다시 더함
                        i++;
                    } else if (option == '#') {
                        current *= -1;
                        i++;
                    }
                }

                sum += current;
                previous = current;
            }
        }

        return sum;
    }
}
