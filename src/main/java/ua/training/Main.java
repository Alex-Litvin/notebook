package ua.training;

import ua.training.controller.Controller;
import ua.training.model.entity.Model;
import ua.training.view.View;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.userProcess();
    }
}
