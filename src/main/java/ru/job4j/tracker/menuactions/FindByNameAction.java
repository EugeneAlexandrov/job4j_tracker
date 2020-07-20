package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Name ===");
        String name = input.askStr("Enter name of item: ");
        Item[] array = tracker.findByName(name);
        if (array.length > 0) {
            for (Item item : array) System.out.println(item);
        } else System.out.println("item с таким именем не найден");
        System.out.println("======================");
        return true;
    }
}
