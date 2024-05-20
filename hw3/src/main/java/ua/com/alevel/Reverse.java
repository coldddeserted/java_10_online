package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;

        System.out.println("Enter text to reverse");
        text = reader.readLine();
        System.out.println("Enter 1 to reverse");
        System.out.println("Enter 2 to reverse with choose text");
        System.out.println("Enter 3 to reverse with your index");

        switch (Integer.parseInt(reader.readLine())) {
            case 1:
                System.out.println(reverse(text));
                break;
            case 2:
                System.out.println("Enter text to reverse");
                String toReverse = reader.readLine();
                System.out.println(reverse(text, toReverse));
                break;
            case 3:
                System.out.println("Enter 2 index to reverse");
                int firstIndex = Integer.parseInt(reader.readLine());
                int lastIndex = Integer.parseInt(reader.readLine());
                System.out.println(reverse(text, firstIndex, lastIndex));
                break;
        }
    }

    public static String reverse(String toReverse) {
        char[] chars = toReverse.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static String reverse(String toReverse, String partToReverse) {
        int start = toReverse.indexOf(partToReverse);
        int end = start + partToReverse.length();
        String notChangedStart = toReverse.substring(0, start);
        String notChangedEnd = toReverse.substring(end);
        String reversedSubstr = reverse(toReverse.substring(start, end));
        return notChangedStart + reversedSubstr + notChangedEnd;
    }

    public static String reverse(String toReverse, int firstIndex, int lastIndex) {
        String notChangedStart = toReverse.substring(0, firstIndex);
        String notChangedEnd = toReverse.substring(lastIndex);
        String middle = toReverse.substring(firstIndex, lastIndex);
        String reversedMiddle = reverse(middle);
        return notChangedStart + reversedMiddle + notChangedEnd;
    }
}