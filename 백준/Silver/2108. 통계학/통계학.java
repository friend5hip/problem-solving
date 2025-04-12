import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(numbers);

        double average = (double) sum / n;
        System.out.println(Math.round(average));

        System.out.println(numbers[n / 2]);

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);
        if (modes.size() > 1) {
            System.out.println(modes.get(1));
        } else {
            System.out.println(modes.get(0));
        }

        System.out.println(numbers[n - 1] - numbers[0]);
    }
}
