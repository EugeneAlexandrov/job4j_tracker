package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerEagerLoading1 {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerEagerLoading1() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerEagerLoading1.getInstance();
    }
}
