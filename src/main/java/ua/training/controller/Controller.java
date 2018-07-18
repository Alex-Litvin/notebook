package ua.training.controller;

import ua.training.model.entity.Model;
import ua.training.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void userProcess() {
        Scanner scanner = new Scanner(System.in);
        Reader reader = new Reader(view, scanner);
        reader.addContact(model);
        model.printContacts();
    }
}
