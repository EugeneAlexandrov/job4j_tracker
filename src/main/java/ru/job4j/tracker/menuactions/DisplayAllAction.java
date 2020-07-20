package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.*;

public class DisplayAllAction implements UserAction {
    private final Output out;

    public DisplayAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "List of Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== List of Items ===");
        for (Item item : tracker.findAll()) {
            out.println(item);
        }
        out.println("======================");
        return true;
    }
}
