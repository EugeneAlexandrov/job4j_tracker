package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Delete Item ====");
        int id = input.askInt("Enter id of Item: ");
        if (tracker.delete(id)) {
            out.println("id " + id + " успешно удален");
        } else {
            out.println("item c таким id не найден");
        }
        out.println("======================");
        return true;
    }
}
