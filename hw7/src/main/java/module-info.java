module ua.com.alevel.hw7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ua.com.alevel.hw7 to javafx.fxml;
    exports ua.com.alevel.hw7;
    exports ua.com.alevel.hw7.config;
    exports ua.com.alevel.hw7.entity;
    exports ua.com.alevel.hw7.reactiv;
    exports ua.com.alevel.hw7.controller;
    exports ua.com.alevel.hw7.db;
    exports ua.com.alevel.hw7.service;
    exports ua.com.alevel.hw7.service.impl;

    opens ua.com.alevel.hw7.controller to javafx.fxml;
}