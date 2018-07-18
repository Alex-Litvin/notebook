package ua.training.controller;

import ua.training.model.entity.Contact;
import ua.training.model.entity.Model;
import ua.training.model.exception.NotUniqueLoginException;
import ua.training.model.ContactConstants;
import ua.training.view.View;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Reader implements ContactConstants, VerificationConstants {
    private View view;
    private Scanner sc;
    private ResourceBundle bundle = LanguageConfig.selectLanguage();

    public Reader(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void addContact(Model model) {
        Contact contact = new Contact();
        contact.setFirstName(getUserInput(bundle.getString(NAME_PATTERN),
                String.format(bundle.getString(INPUT_DATA), bundle.getString(FIRST_NAME), bundle.getString(FIRST_NAME_EXAMPLE))));
        contact.setLastName(getUserInput(bundle.getString(NAME_PATTERN),
                String.format(bundle.getString(INPUT_DATA), bundle.getString(LAST_NAME), bundle.getString(LAST_NAME_EXAMPLE))));
        inputLogin(model, contact);

        model.addContact(contact);
    }

    private void inputLogin(Model model, Contact contact) {
        contact.setLogin(getUserInput(bundle.getString(LOGIN_PATTERN),
                String.format(bundle.getString(INPUT_DATA),
                        bundle.getString(NICKNAME),
                        bundle.getString(LOGIN_EXAMPLE))));
        try {
            model.checkLogin(contact);
        } catch (NotUniqueLoginException e) {
            view.printMessage(e.getMessage());
            inputLogin(model, contact);
        }
    }

    private String getUserInput(String pattern, String message) {
        String error = bundle.getString(WRONG_INPUT);
        view.printMessage(message);
        String input = sc.nextLine();
        while (!verify(input, pattern)) {
            view.printMessage(String.format(error, message));
            input = sc.nextLine();
        }
        return input;
    }

    private boolean verify(String userInput, String pattern) {
        return userInput.matches(pattern);
    }
}
