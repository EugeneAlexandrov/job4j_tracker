package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.*;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Edit Item ====");
        int id = input.askInt("Enter id of Item to edit: ");
        String name = input.askStr("Enter new name of item: ");
        Item item = new Item(id, name);
        if (tracker.replace(id, item)) {
            out.println("id " + id + " успешно изменен%n");
        } else {
            out.println("item c таким id не найден");
        }
        out.println("======================");
        return true;
    }
}
