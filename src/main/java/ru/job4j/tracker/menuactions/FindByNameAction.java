package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.*;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by Name ===");
        String name = input.askStr("Enter name of item: ");
        Item[] array = tracker.findByName(name);
        if (array.length > 0) {
            for (Item item : array) {
                out.println(item);
            }
        } else {
            out.println("item с таким именем не найден");
        }
        out.println("======================");
        return true;
    }
}
