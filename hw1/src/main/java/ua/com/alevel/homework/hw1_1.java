package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw1_1{
    static int result = 0;
    static String input;
    public static void Sum() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))) result += input.charAt(i)-'0';
        }

        System.out.println(result);
    }
}