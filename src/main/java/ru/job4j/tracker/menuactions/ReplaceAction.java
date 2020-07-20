package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Edit Item ====");
        int id = input.askInt("Enter id of Item to edit: ");
        String name = input.askStr("Enter new name of item: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            System.out.printf("id %d успешно изменен%n", id);
        } else System.out.println("item c таким id не найден");
        System.out.println("======================");
        return true;
    }
}
