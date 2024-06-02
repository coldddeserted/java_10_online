package ua.com.alevel.hw7.controller;

import ua.com.alevel.hw7.config.LoaderPage;
import ua.com.alevel.hw7.reactiv.NativePubSub;

public class RootLayoutController {

    public void showStudents() {
        NativePubSub.getInstance().publish(LoaderPage.STUDENTS);
    }

    public void showGroups() {
        NativePubSub.getInstance().publish(LoaderPage.GROUPS);
    }
}
