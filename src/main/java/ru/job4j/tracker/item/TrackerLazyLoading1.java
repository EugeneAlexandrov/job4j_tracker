package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerLazyLoading1 {
    private static Tracker instance;

    private TrackerLazyLoading1() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
