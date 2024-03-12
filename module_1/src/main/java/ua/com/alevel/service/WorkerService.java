package ua.com.alevel.service;

import ua.com.alevel.db.WorkerStorage;
import ua.com.alevel.entity.Worker;
import ua.com.alevel.factory.WorkerStorageFactory;

public class WorkerService {
    WorkerStorage workerStorage = WorkerStorageFactory.getWorkerStorage();
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
    public Worker seeByGroup(String group) {
        return workerStorage.seeByGroup(group);
    }
}