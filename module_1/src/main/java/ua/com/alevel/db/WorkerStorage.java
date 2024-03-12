package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

public interface WorkerStorage {
    void create(Worker worker);
    Worker seeById(int id);
    Worker[] seeAll();
    void update(Worker worker);
    void delete(int id);
    Worker seeByGroup(String group);
}
