package ru.job4j.tracker;

import ru.job4j.tracker.menuactions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Choose action:");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int i = 0;
        for (UserAction action : actions) {
            out.println(i++ + ":" + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new CreateAction(output),
                new DisplayAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindByIDAction(output),
                new FindByNameAction(output),
                new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}
