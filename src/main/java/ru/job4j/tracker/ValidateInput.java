package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input in;
    private final Output out;

    public ValidateInput(Output out, Input in) {
        this.in = in;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (IllegalStateException moe) {
                out.println("Select key from menu");
            } catch (NumberFormatException nfe) {
                out.println("invalid data. Use number format");
            }
        } while (invalid);
        return value;
    }
}

