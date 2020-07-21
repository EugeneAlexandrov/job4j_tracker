package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.menuactions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void createItem() {
        String[] answers = {"0", "Fix PC", "1"};
        Output output = new ConsoleOutput();
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Fix PC"));
    }

    @Test
    public void editItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Fix PC"));
        Output output = new ConsoleOutput();
        UserAction[] actions = {new ReplaceAction(output), new ExitAction()};
        Input input = new StubInput(new String[]{"0", String.valueOf(item.getId()), "Fix phone", "1"});
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Fix phone"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("deliting item"));
        UserAction[] actions = {new DeleteAction(output), new ExitAction()};
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new StubInput(answers);
        new StartUI(output).init(input, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void findAll() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1"});
        Item item = tracker.add(new Item("task1"));
        UserAction[] actions = {new DisplayAllAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0:List of Items" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator() +
                        "=== List of Items ===" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0:List of Items" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "1", "1"});
        Item item = tracker.add(new Item("task1"));
        UserAction[] actions = {new FindByIDAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0:Find Item by ID" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator() +
                        "=== Find Item by ID ===" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0:Find Item by ID" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0", "task1", "1"});
        Item item = tracker.add(new Item("task1"));
        UserAction[] actions = {new FindByNameAction(output), new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0:Find Item by Name" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator() +
                        "=== Find Item by Name ===" + System.lineSeparator() +
                        item.toString() + System.lineSeparator() +
                        "======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0:Find Item by Name" + System.lineSeparator() +
                        "1:Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void exit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitAction()};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0:Exit" + System.lineSeparator()
        ));
    }
}