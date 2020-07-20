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
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Fix PC");
        tracker.add(item);
        UserAction[] actions = {new ReplaceAction(), new ExitAction()};
        String[] answers = {"0", String.valueOf(item.getId()), "Fix phone", "1"};
        Input input = new StubInput(answers);
        new StartUI().init(input, tracker, actions);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("Fix phone"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("deliting item");
        tracker.add(item);
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        new StartUI().init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }
}