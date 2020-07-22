package ru.job4j.tracker.item;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerLazyLoading2 {
    private TrackerLazyLoading2() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerLazyLoading2.getInstance();
    }
}
