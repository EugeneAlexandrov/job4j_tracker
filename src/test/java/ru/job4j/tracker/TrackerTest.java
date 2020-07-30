package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparators.IDComparator;
import ru.job4j.tracker.comparators.NameAscComparator;
import ru.job4j.tracker.comparators.NameDescComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void sortItemsByNameAsc() {
        List<Item> items = new ArrayList<>();
        Item task1 = new Item(0, "B");
        Item task2 = new Item(1, "A");
        items.add(task1);
        items.add(task2);
        Collections.sort(items, new NameAscComparator());
        List<Item> expected = new ArrayList<>();
        expected.add(task2);
        expected.add(task1);
        assertThat(items.get(0).getName(), is(expected.get(0).getName()));
    }

    @Test
    public void sortItemsByNameDesc() {
        List<Item> items = new ArrayList<>();
        Item task1 = new Item(0, "Aaa");
        Item task2 = new Item(1, "Aab");
        items.add(task1);
        items.add(task2);
        items.sort(new NameDescComparator());
        List<Item> expected = new ArrayList<>();
        expected.add(task2);
        expected.add(task1);
        assertThat(items.get(0).getName(), is(expected.get(0).getName()));
    }
}