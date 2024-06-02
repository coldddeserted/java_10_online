package ua.com.alevel.hw7.reactiv;

import ua.com.alevel.hw7.config.LoaderPage;

import java.util.function.Consumer;

public class NativePubSub {
    private static final NativePubSub instance = new NativePubSub();
    private Consumer<LoaderPage> publisher;
    private Consumer<Boolean> publisherGroup;
    private Consumer<Boolean> publisherStudent;

    private NativePubSub() {    }

    public static NativePubSub getInstance() {
        return instance;
    }

    public void publish(LoaderPage page) {
        publisher.accept(page);
    }
    public void subscribe(Consumer<LoaderPage> consumer) {
        this.publisher = consumer;
    }

    public void publishGroup(Boolean publishGroup) {
        publisherGroup.accept(publishGroup);
    }
    public void subscribeGroup(Consumer<Boolean> consumer) {
        this.publisherGroup = consumer;
    }

    public void publishStudent(Boolean publishStudent) {
        publisherStudent.accept(publishStudent);
    }
    public void subscribeStudent(Consumer<Boolean> consumer) {
        this.publisherStudent = consumer;
    }
}
