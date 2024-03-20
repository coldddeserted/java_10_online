package ua.com.alevel.db;

import ua.com.alevel.entity.Boss;

public class DbBoss{
    static Boss[] bosses = new Boss[4];
    public static void create(Boss boss) {
        switch (boss.getGroup()) {
            case "Cashier":
                bosses[0] = boss;
                break;
            case "Security":
                bosses[1] = boss;
                break;
            case "Stock":
                bosses[2] = boss;
                break;
            case "Manager":
                bosses[3] = boss;
                break;
        }
    }
    public static Boss seeByGroup(String group) {
        Boss bossToAnswer = null;
        switch (group) {
            case "Cashier":
                bossToAnswer = bosses[0];
                break;
            case "Security":
                bossToAnswer = bosses[1];
                break;
            case "Stock":
                bossToAnswer = bosses[2];
                break;
            case "Manager":
                bossToAnswer = bosses[3];
                break;
        }
        return bossToAnswer;
    }
}
