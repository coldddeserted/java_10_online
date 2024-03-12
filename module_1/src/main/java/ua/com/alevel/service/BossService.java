package ua.com.alevel.service;

import ua.com.alevel.db.WorkerStorage;
import ua.com.alevel.factory.WorkerStorageFactory;

public class BossService {
    WorkerStorage workerStorage = WorkerStorageFactory.getWorkerStorage();
}
