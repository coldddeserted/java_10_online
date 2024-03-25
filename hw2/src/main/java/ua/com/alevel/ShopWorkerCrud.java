package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopWorkerCrud {
    static int countPersons = 0;
    ShopWorker[] shopWorkers = new ShopWorker[10];
    String firstName;
    String lastName;
    int id;
    public void createArrays() {
        ShopWorker[] transferShopWorkers = new ShopWorker[shopWorkers.length];
        ShopWorker[] shopWorkers = new ShopWorker[transferShopWorkers.length+10];
        System.arraycopy(transferShopWorkers, 0, shopWorkers, 0, shopWorkers.length);
    }
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu();
        select(Integer.parseInt(reader.readLine()));
    }
    public void menu() {
        System.out.println("Enter 1 if you want to add new worker");
        System.out.println("Enter 2 if you want to see all worker");
        System.out.println("Enter 3 if you want to update worker");
        System.out.println("Enter 4 if you want to delete worker");
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
                update();
                break;
            case 4:
                delete();
                break;
            case 0:
                break;
        }
    }
    public void create() throws IOException {
        if(countPersons%10==0 && countPersons!=0) {
            createArrays();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your first name");
        firstName = reader.readLine();
        System.out.println("Please enter your last name");
        lastName = reader.readLine();
        ShopWorker shopWorker = new ShopWorker();
        shopWorker.firstName = firstName;
        shopWorker.lastName = lastName;
        for (int i = 0; i < shopWorkers.length; i++) {
            if(shopWorkers[i]==null){
                shopWorkers[i] = shopWorker;
                break;
            }
        }
        countPersons++;
        start();
    }
    public void seeAll() throws IOException {
        for (int i = 0; i < shopWorkers.length; i++) {
            if(shopWorkers[i]!=null) {
                System.out.println("First name: " + shopWorkers[i].firstName + ", Last name: " + shopWorkers[i].lastName
                        + ", id: " + i);
            }
        }
        start();
    }
    public void update() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter id person to update");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Please enter new first name");
        firstName = reader.readLine();
        System.out.println("Please enter new last name");
        lastName = reader.readLine();
        ShopWorker shopWorker = new ShopWorker();
        shopWorker.firstName = firstName;
        shopWorker.lastName = lastName;
        shopWorkers[id] = shopWorker;
        start();
    }
    public void delete() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter id person to update");
        id = Integer.parseInt(reader.readLine());
        shopWorkers[id] = null;
        countPersons--;
        start();
    }
}