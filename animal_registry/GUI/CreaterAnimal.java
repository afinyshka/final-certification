package animal_registry.GUI;

import java.util.Scanner;

import animal_registry.Classes.*;

public class CreaterAnimal {
    private Scanner ansc;

    public CreaterAnimal() {
        this.ansc = new Scanner(System.in);
    }

    public Animal animalCreater(String typeAnimal) {
        // Scanner ansc = new Scanner(System.in);
        System.out.printf("Enter %s's name: ", typeAnimal);
        String name = ansc.next();
        System.out.printf("Enter %s's birthdate: ", typeAnimal);
        String birthdate = ansc.next();
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
