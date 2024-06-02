package ua.com.alevel.hw7;

import javafx.application.Application;
import javafx.stage.Stage;
import ua.com.alevel.hw7.config.AppConfig;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppConfig.init(stage, HelloApplication.class);
    }

    public static void main(String[] args) {
        launch();
    }
}