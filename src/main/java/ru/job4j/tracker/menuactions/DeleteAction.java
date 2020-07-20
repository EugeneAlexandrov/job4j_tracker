package ru.job4j.tracker.menuactions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Delete Item ====");
        int id = input.askInt("Enter id of Item: ");
        if (tracker.delete(id)) {
            System.out.printf("id %d успешно удален%n", id);
        } else System.out.println("item c таким id не найден");
        System.out.println("======================");
        return true;
    }
}
