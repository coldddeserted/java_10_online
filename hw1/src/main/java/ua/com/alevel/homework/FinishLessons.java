package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FinishLessons {
    static int time = 9*60;
    static int littleBreak = 5;
    static int pairedBreak = 20;
    static int countOfLessons;
    static int pair;
    static int remainder;
    static int lesson = 45;
    public static void lessons() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        countOfLessons = Integer.parseInt(reader.readLine()) - 1;

        pair = countOfLessons/2;
        remainder = countOfLessons%2;

        time += lesson + remainder*(lesson+littleBreak) + pair*(lesson*2 + pairedBreak);

        System.out.println(time/60 + ":" + time%60);
    }
}
