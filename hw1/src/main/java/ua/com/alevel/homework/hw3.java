package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw3 {
    public static String answer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;

        System.out.println("Enter text to reverse");
        text = reader.readLine();
        System.out.println("Enter 1 to reverse");
        System.out.println("Enter 2 to reverse with choose text");
        System.out.println("Enter 3 to reverse with your index");

            switch (Integer.parseInt(reader.readLine())) {
                case 1: reverse(text);
                case 2: {
                    System.out.println("Enter text to reverse");
                    String toReverse = reader.readLine();
                    reverse(text, toReverse);
                }
                case 3: {
                    System.out.println("Enter 2 index to reverse");
                    int index1 = Integer.parseInt(reader.readLine());
                    int index2 = Integer.parseInt(reader.readLine());
                    reverse(text, index1, index2);
                }
            }
    }

    public static void reverse (String input) {
        for (int i = input.length() - 1; i == 0; i--) {
            answer += input.charAt(i);
        }
        System.out.println(answer);
    }

    public static void reverse (String input, String choose) {

    }

    public static void reverse (String input, int index1, int index2) {

    }
}