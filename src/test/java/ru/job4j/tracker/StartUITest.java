package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.menuactions.CreateAction;
import ru.job4j.tracker.menuactions.DeleteAction;
import ru.job4j.tracker.menuactions.ExitAction;
import ru.job4j.tracker.menuactions.ReplaceAction;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answers = {"0", "Fix PC", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Fix PC"));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Fix PC"));
        UserAction[] actions = {new ReplaceAction(), new ExitAction()};
        Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), "Fix phone", "1"});
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Fix phone"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("deliting item"));
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        new StartUI().init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }
}