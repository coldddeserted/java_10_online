package ua.com.alevel.service;

import ua.com.alevel.db.DbBoss;
import ua.com.alevel.entity.Boss;

public class BossService {
    public static Boss seeByGroup(String group) {
        return DbBoss.seeByGroup(group);
    }
}
