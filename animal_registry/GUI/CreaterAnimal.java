package animal_registry.GUI;

import java.io.IOException;
import java.util.Scanner;

import animal_registry.Classes.*;
import animal_registry.Exceptions.AttrChecker;

public class CreaterAnimal {
    private Scanner ansc;

    public CreaterAnimal() {
        this.ansc = new Scanner(System.in);
    }

    public Animal animalCreater(String typeAnimal) throws IOException {
        // Scanner ansc = new Scanner(System.in);
        AttrChecker atrChecker = new AttrChecker();
        System.out.printf("Enter %s's name: ", typeAnimal);
        String name = ansc.next();
        atrChecker.stringChecker(name);
        System.out.printf("Enter %s's birthdate in format 00.00.0000: ", typeAnimal);
        String birthdate = ansc.next();
        atrChecker.dateChecker(birthdate);
        if (typeAnimal == "cat") {
            return new Cat(name, birthdate);
        } else if (typeAnimal == "dog") {
            return new Dog(name, birthdate);
        } else if (typeAnimal == "humster") {
            return new Humster(name, birthdate);
        } else if (typeAnimal == "horse") {
            return new Horse(name, birthdate);
        } else if (typeAnimal == "donkey") {
            return new Donkey(name, birthdate);
        } else if (typeAnimal == "camel") {
            return new Camel(name, birthdate);
        }
        ansc.close();
        return null;
    }
}
