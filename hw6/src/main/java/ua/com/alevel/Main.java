package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    static String text;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text");
        text = reader.readLine();
        wordRating(text);
    }

    public static void wordRating(String text) {
        List<String> list = Arrays.stream(text.split(" "))
                .map(w -> w.replaceAll("[^À-ÿà-ÿa-zA-Z0-9]", " "))
                .filter(w -> !w.isEmpty())
                .map(w -> w.toLowerCase())
                .toList();

        int size = list.size();

        Map<String, Long> map = list.stream()
                .collect(groupingBy(w -> w, counting()));

        List<Word> words = map.entrySet().stream()
                .map(w -> new Word(w.getKey(), w.getValue(), (long) ((double)w.getValue() / size * 100)))
                .sorted(Comparator.comparing(Word::getPercantage).reversed())
                .toList();
        IntStream.range(0, words.size())
                .forEach(i -> words.get(i).setRating(i + 1));

        System.out.printf("%-10s %-10s %-10s %-10s \n", "", "Rating", "Count", "Percantage");
        words.forEach(word -> System.out.printf("%-10s %-10s %-10s %-10s \n", word.getWord(), word.getRating(), word.getCount(), word.getPercantage()));
    }
}