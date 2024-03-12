package ua.com.alevel.db;

import ua.com.alevel.entity.Boss;
import ua.com.alevel.entity.Groups;

public class BossStorage extends Groups{
    static Boss[] bosses = new Boss[4];
    public static void create(Boss boss) {
        Groups groups = new Groups();
        for (int i = 0; i < 4; i++) {
            if(bosses[i]==null) {
                boss.setGroup(groups.group[i]);
                bosses[i]=boss;
                System.out.println(bosses[i].getGroup());
            }
        }
    }
}
