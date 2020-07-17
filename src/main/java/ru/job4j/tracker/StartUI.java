package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Choose action:");
            if (select == 0) {
//              0. Add new Item
                System.out.println("=== Create a new Item ===");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
//              1. Show all items
                System.out.println("=== List of Items ===");
                for (Item item : tracker.findAll()) {
                    System.out.println(item);
                }
                System.out.println("======================");
            } else if (select == 2) {
//              2. Edit item
                System.out.println("==== Edit Item ====");
                int id = input.askInt("Enter id of Item to edit: ");
                String name = input.askStr("Enter new name of item: ");
                Item item = new Item(id, name);
                if (tracker.replace(id, item)) {
                    System.out.printf("id %d успешно изменен%n", id);
                } else System.out.println("item c таким id не найден");
                System.out.println("======================");
            } else if (select == 3) {
//              3. Delete item
                System.out.println("==== Delete Item ====");
                int id = input.askInt("Enter id of Item: ");
                if (tracker.delete(id)) {
                    System.out.printf("id %d успешно удален%n", id);
                } else System.out.println("item c таким id не найден");
                System.out.println("======================");
            } else if (select == 4) {
//              4. Find item by Id
                System.out.println("=== Find Item by ID ===");
                int id = input.askInt("Enter id of item: ");
                if (id != -1) {
                    System.out.println(tracker.findById(id));
                } else {
                    System.out.println("item c таким id не найден");
                }
                System.out.println("======================");
            } else if (select == 5) {
//              5. Find items by name
                System.out.println("=== Find Item by Name ===");
                String name = input.askStr("Enter name of item: ");
                Item[] array = tracker.findByName(name);
                if (array.length > 0) {
                    for (Item item : array) System.out.println(item);
                } else System.out.println("item с таким именем не найден");
                System.out.println("======================");
            } else if (select == 6) {
                run = false;
            }
        }

    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
