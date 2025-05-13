class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while (true) {
            if (i >= s.length()) break;
            char current = s.charAt(i);
            // 현재 문자가 숫자라면 그대로 문자열에 추가
            if (Character.isDigit(current)) {
                sb.append(String.valueOf(current)); 
                i++;
                continue;
            }
            switch (current) {
                case 'z': 
                    sb.append("0");
                    i += 4;
                    break;
                case 'o':
                    sb.append("1");
                    i += 3;
                    break;
                case 't':
                    if (s.substring(i, i+2).equals("tw")) {
                        sb.append("2");
                        i += 3;
                    } else if (s.substring(i, i+2).equals("th")) {
                        sb.append("3");
                        i += 5;
                    }
                    break;
                case 'f':
                    if (s.substring(i, i+2).equals("fo")) {
                        sb.append("4");
                        i += 4;
                    } else if (s.substring(i, i+2).equals("fi")) {
                        sb.append("5");
                        i += 4;
                    }
                    break;
                case 's':
                    if (s.substring(i, i+2).equals("si")) {
                        sb.append("6");
                        i += 3;
                        break;
                    } else if (s.substring(i, i+2).equals("se")) {
                        sb.append("7");
                        i += 5;
                    }
                    break;
                case 'e':
                    sb.append("8");
                    i += 5;
                    break;
                case 'n':
                    sb.append("9");
                    i += 4;
                    break;
            }
        }
        
        int answer = Integer.parseInt(sb.toString());
        
        return answer;
    }
}