package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.*;

public class FindByIDAction implements UserAction {
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by ID";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by ID ===");
        int id = input.askInt("Enter id of item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("item c таким id не найден");
        }
        out.println("======================");
        return true;
    }
}
