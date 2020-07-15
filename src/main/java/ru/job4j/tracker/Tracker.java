package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] tasksWithKey = new Item[items.length];
        int size = 0;
        for (int index = 0; index < this.size; index++) {
            if (items[index].getName().equals(key)) {
                tasksWithKey[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(tasksWithKey, size);
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        item.setId(id);
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            items[indexOf(id)] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int distPos = indexOf(id);
        int startPos = distPos + 1;
        int size = this.size - startPos;
        boolean rsl = indexOf(id) != -1;
        if (rsl) {
            System.arraycopy(items, startPos, items, distPos, size);
            items[this.size - 1] = null;
            this.size--;
        }
        return rsl;
    }
}