package ua.com.alevel.factory;

import ua.com.alevel.db.DbWorker;
import ua.com.alevel.db.WorkerStorage;

public class WorkerStorageFactory {
    private final static WorkerStorage workerStorage = new DbWorker();

    public static WorkerStorage getWorkerStorage() {
        return workerStorage;
    }
}
