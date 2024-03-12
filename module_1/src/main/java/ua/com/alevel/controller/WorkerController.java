package ua.com.alevel.controller;

import ua.com.alevel.db.BossStorage;
import ua.com.alevel.entity.Boss;
import ua.com.alevel.entity.Worker;
import ua.com.alevel.service.WorkerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WorkerController {
    private final WorkerService workerService = new WorkerService();
    static int countPersons = 0;
    Worker[] workers = new Worker[10];
    String firstName;
    String lastName;
    String groupName;
    int id;
    public void createArrays() {
        Worker[] transferWorker = workers.clone();
        Worker[] workers = new Worker[transferWorker.length+10];
        workers = transferWorker.clone();
    }
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        createBoss();
        menu();
        select(Integer.parseInt(reader.readLine()));
    }
    public void menu() {
        System.out.println("Enter 1 if you want to add new worker");
        System.out.println("Enter 2 if you want to see all worker");
        System.out.println("Enter 3 if you want to see worker by id");
        System.out.println("Enter 4 if you want to see worker by group");
        System.out.println("Enter 5 if you want to update worker");
        System.out.println("Enter 6 if you want to delete worker");
        System.out.println("Enter 0 if you want to exit");
    }
    public void select(int choice) throws IOException {
        switch (choice){
            case 1:
                create();
                break;
            case 2:
                seeAll();
                break;
            case 3:
                seeById();
                break;
            case 4:
                seeByGroup();
                break;
            case 5:
                update();
                break;
            case 6:
                delete();
                break;
            case 0:
                break;
        }
    }
    public void create() throws IOException {
        if(countPersons%10==0 && countPersons!=0) {
            //createArrays();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your first name");
        firstName = reader.readLine();
        System.out.println("Please enter your last name");
        lastName = reader.readLine();
        System.out.println("Please enter your group");
        groupName = reader.readLine();
        Worker worker = new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        for (int i = 0; i < workers.length; i++) {
            if(workers[i]==null){
                workerService.create(worker);
                break;
            }
        }
        countPersons++;
        start();
    }
    public void seeAll() throws IOException {
        Worker[] workers = workerService.seeAll();
        for (int i = 0; i < workers.length; i++) {
            if(workers[i]!=null) {
                System.out.println("First name: " + workers[i].getFirstName() + ", Last name: " + workers[i].getLastName()
                        + ", id: " + i);
            }
        }
        start();
    }

    public void seeById() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter id person to see");
        id = Integer.parseInt(reader.readLine());
        workerService.seeById(id);
        start();
    }

    public void seeByGroup() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter group to see");
        groupName = reader.readLine();

    }
    public void update() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter id person to update");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Please enter new first name");
        firstName = reader.readLine();
        System.out.println("Please enter new last name");
        lastName = reader.readLine();
        Worker worker = new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setGroupName(groupName);
        workerService.update(worker);
        start();
    }
    public void delete() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter id person to delete");
        id = Integer.parseInt(reader.readLine());
        workerService.delete(id);
        if(workerService.seeById(id)==null) countPersons--;
        start();
    }
    public void createBoss() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Boss boss = new Boss();
        System.out.println("Please enter first name Cashier Boss");
        firstName = reader.readLine();
        System.out.println("Please enter last name Cashier Boss");
        lastName = reader.readLine();
        boss.setFirstName(firstName);
        boss.setLastName(lastName);
        BossStorage.create(boss);
    }
}