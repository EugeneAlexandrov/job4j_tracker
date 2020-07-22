package ru.job4j.tracker.item;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.*;

public class TrackerCreateTest {

    @Test
    public void getEnumTracker() {
        Tracker tracker = EnumTracker.INSTANCE.getTracker();
        Tracker tracker2 = EnumTracker.INSTANCE.getTracker();
        assertEquals(tracker, tracker2);
    }

    @Test
    public void getTrackerEagerLoading1() {
        Tracker tracker = TrackerEagerLoading1.getInstance();
        Tracker tracker2 = TrackerEagerLoading1.getInstance();
        assertEquals(tracker, tracker2);
    }

    @Test
    public void getTrackerLazyLoading1() {
        Tracker tracker = TrackerLazyLoading1.getInstance();
        Tracker tracker2 = TrackerLazyLoading1.getInstance();
        assertEquals(tracker, tracker2);
    }

    @Test
    public void getTrackerLazyLoading2() {
        Tracker tracker = TrackerLazyLoading2.getInstance();
        Tracker tracker2 = TrackerLazyLoading2.getInstance();
        assertEquals(tracker, tracker2);
    }

}