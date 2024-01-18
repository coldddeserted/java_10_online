package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumFromChar {
    static int result = 0;
    static String input;
    public static void SumFromChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();
        char [] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>='1'&&chars[i]<='9') result += chars[i]-'0';
        }

        System.out.println(result);
    }
}