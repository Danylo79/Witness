package dev.dankom.witness.logger.anim;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dialog {
    private final Map<String, String> questions = new HashMap<>();

    public void registerQuestion(String question, String def) {
        questions.put(question, def);
    }

    public Map<String, String> start() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> out = new HashMap<>();
        for (Map.Entry<String, String> question : questions.entrySet()) {
            String questionString = question.getKey() + (question.getValue() != null ? " (" + question.getValue() + "): " : "");
            System.out.print(questionString);

            String read = scanner.nextLine();
            if (!read.equals("")) {
                out.put(question.getKey(), read);
            } else {
                out.put(question.getKey(), question.getValue());
            }
        }
        return out;
    }

    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.registerQuestion("1", "1");
        dialog.registerQuestion("2", "2");
        dialog.registerQuestion("3", "3");
        dialog.registerQuestion("4", "4");
        dialog.registerQuestion("5", "5");
        Map<String, String> out = dialog.start();
        for (Map.Entry<String, String> question : out.entrySet()) {
            System.out.println(question.getKey() + ": " + question.getValue());
        }
    }
}
