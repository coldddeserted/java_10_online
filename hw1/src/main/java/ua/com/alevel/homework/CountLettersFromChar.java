package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountLettersFromChar {
    static int count = 0;
    static String input;
    public static void CountLettersFromChar() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        input = reader.readLine();
        char [] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>='A'&&chars[i]<='Z' || chars[i]>='a'&&chars[i]<='z' || chars[i]>='А'&&chars[i]<='Я' || chars[i]<='а'&&chars[i]>='я') {
                System.out.print(chars[i]);
                for (int j = chars.length-1; j >= i; j--) {
                    if(chars[j]==chars[i]) {
                        count++;
                        chars[j]='0';
                    }
                }
                System.out.println(" = " + count);
                count=0;
            }
        }
    }
}
