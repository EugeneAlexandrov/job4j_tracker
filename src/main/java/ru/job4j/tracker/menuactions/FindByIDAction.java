package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class FindByIDAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by ID ===");
        int id = input.askInt("Enter id of item: ");
        if (id != -1) {
            System.out.println(tracker.findById(id));
        } else {
            System.out.println("item c таким id не найден");
        }
        System.out.println("======================");
        return true;
    }
}
