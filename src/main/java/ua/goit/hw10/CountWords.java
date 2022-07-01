package ua.goit.hw10;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CountWords {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("test3.txt"));
        String line = "";
        while (scanner.hasNextLine()) {
            line = line + scanner.nextLine() + " ";
        }
        scanner.close();
        String[] words = line.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String newword : words) {
            Integer count = map.get(newword);
            if (count == null) {
                count = 0;
            }
            map.put(newword, count + 1);
        }

        for (String word : map.keySet()) {
            System.out.println(word + " " + map.get(word));
        }

        Map<String, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));
        System.out.println("--------Befor sorted------------");
        for (var entry : sortedMap.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
        }
    }
}
