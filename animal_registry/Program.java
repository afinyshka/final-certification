package animal_registry;

import java.io.IOException;

import animal_registry.GUI.UserInterface;


public class Program {
    public static void main(String[] args) throws IOException {
        UserInterface ui = new UserInterface();
        ui.consoleUI();
    }
}
