package ua.com.alevel.service;

import ua.com.alevel.db.DbWorker;
import ua.com.alevel.entity.Worker;

public class WorkerService {
    static DbWorker workerStorage = new DbWorker();
    public void create(Worker worker) {
        if (worker.getFirstName() != null) {
            workerStorage.create(worker);
        }
    }
    public void update(Worker worker) {
        Worker current = workerStorage.seeById(worker.getId());
        if (current != null) {
            workerStorage.update(worker);
        }
    }
    public void delete(int id) {
        Worker current = workerStorage.seeById(id);
        if (current != null) {
            workerStorage.delete(id);
        }
    }
    public Worker[] seeAll() {
        return workerStorage.seeAll();
    }
    public Worker seeById(int id) {
        return workerStorage.seeById(id);
    }
    public static Worker seeByGroup(String group) {
        return workerStorage.seeByGroup(group);
    }
}