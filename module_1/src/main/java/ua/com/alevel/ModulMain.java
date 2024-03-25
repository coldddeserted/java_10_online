package ua.com.alevel;

import ua.com.alevel.controller.WorkerController;

import java.io.IOException;

public class ModulMain {
    public static void main(String[] args) throws IOException {
        WorkerController workerController = new WorkerController();
        workerController.start();
    }
}