package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class DisplayAllAction implements UserAction {
    @Override
    public String name() {
        return "List of Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== List of Items ===");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println("======================");
        return true;
    }
}
