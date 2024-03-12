package ua.com.alevel;

import java.io.IOException;

public class CrudMain {
    public static void main(String[] args) throws IOException {
        ShopWorkerCrud shopWorkerCrud = new ShopWorkerCrud();
        shopWorkerCrud.start();
    }
}