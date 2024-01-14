package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw1_2 {
    static int result = 0;
    static String input;
    public static void count() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            if(Character.isAlphabetic(input.charAt(i))) ;
        }

        System.out.println(result);
    }
}
