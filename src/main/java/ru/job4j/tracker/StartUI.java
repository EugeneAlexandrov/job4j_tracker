package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item(0, "task1"));
        tracker.add(new Item(0, "task2"));
        tracker.add(new Item(0, "task3"));
        tracker.add(new Item(0, "item4"));
        System.out.println(tracker.findById(3));
        Item[] itemsByName = tracker.findByName("task2");
        for (Item item : itemsByName) {
            System.out.println(item);
        }
    }
}
