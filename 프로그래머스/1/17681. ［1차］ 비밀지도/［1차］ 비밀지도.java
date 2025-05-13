class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            int orOperation = arr1[i] | arr2[i];
            String binary = Integer.toBinaryString(orOperation);
            StringBuilder sb = new StringBuilder();
            if (binary.length() < n) {
                for (int k = 0; k < n - binary.length(); k++) {
                    sb.append(" ");
                }
            }
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    sb.append("#");
                } else if (binary.charAt(j) == '0') {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

}