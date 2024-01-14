package ua.com.alevel.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw1_3 {
    static int time = 9*60;
    static int countOfLessons;
    static int pair;
    static int remainder;
    static int firstLesson = 45;
    public static void lessons() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        countOfLessons = Integer.parseInt(reader.readLine()) - 1; // -1 для того, чтобы добавить первый урок

        pair = countOfLessons/2; // считаю пары уроков, ведь каждая пара с переменами идёт 110 минут
        remainder = countOfLessons%2; // чтобы добавить урок, который не попал в пару, и он будет 50 минут

        time += firstLesson + remainder*50 + pair*110;

        System.out.println(time/60 + ":" + time%60);
    }
}
