import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            numbers[i] = number;
            map.put(number, map.getOrDefault(number, 0) + 1);
            sum += numbers[i];
        }
        Arrays.sort(numbers);
        List<Map.Entry<Integer, Integer>> mapToList = new ArrayList<>(map.entrySet());
        mapToList.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey() - o2.getKey();
            }
        });
        int average = (int) Math.round((double) sum / n);
        int mid = numbers[(n - 1) / 2];
        int maxFreq = mapToList.get(0).getValue();
        List<Integer> frequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapToList) {
            if (entry.getValue() == maxFreq) {
                frequentNumbers.add(entry.getKey());
            } else {
                break;
            }
        }
        Collections.sort(frequentNumbers);
        int range = Math.abs(numbers[0] - numbers[n - 1]);
        System.out.println(average);
        System.out.println(mid);
        System.out.println(frequentNumbers.size() > 1 ? mapToList.get(1).getKey() : mapToList.get(0).getKey());
        System.out.println(range);
    }
}