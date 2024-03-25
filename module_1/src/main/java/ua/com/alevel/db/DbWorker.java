package ua.com.alevel.db;

import ua.com.alevel.entity.Worker;

public class DbWorker {
    private final Worker[] workers = new Worker[10];
    public void create(Worker worker) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] == null) {
                workers[i] = worker;
                worker.setId(i);
                break;
            }
        }
    }
    public void update(Worker worker) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getId() == worker.getId()) {
                workers[i] = worker;
                break;
            }
        }
    }
    public void delete(int id) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getId() == id) {
                workers[i] = null;
            }
        }
    }
    public Worker[] seeAll() {
        return workers;
    }
    public Worker seeById(int id) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i] != null && workers[i].getId() == id) {
                return workers[i];
            }
        }
        return null;
    }
    public Worker seeByGroup(String group) {
        Worker groupList = null;
        for (int i = 0; i < workers.length; i++) {
            if(workers[i].getGroupName().equals(group)) groupList = workers[i];
        }
        return groupList;
    }
}