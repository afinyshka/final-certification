package animal_registry.GUI;

import java.util.Scanner;

import animal_registry.Classes.*;
import static animal_registry.GUI.CountAnimals.countt;

public class UserInterface {
    private static boolean loop = true;

    public void consoleUI() {
        Zoo zoo = new Zoo();

        // Animal cat1 = new Cat("Kitty", "01.01.2020");
        // Animal dog1 = new Dog("Hunda", "02.02.2021");
        // Animal humster1 = new Humster("picksy", "03.03.2022");
        // Animal horse1 = new Horse("milagress", "04.05.2022");
        // Animal donkey1 = new Donkey("Dosia", "05.05.2021");
        // Animal camel1 = new Camel("Camill", "06.06.2020");
        // zoo.addAnimal(donkey1);
        // zoo.addAnimal(cat1, dog1, humster1, horse1, camel1);

        String infoText = """
                \nPress the number for the command:
                1 - add an animal;
                2 - delete an animal at a specific index;
                3 - show information about all animals and their skills in the zoo;
                4 - show information about animal and their skills at a specific index;
                5 - play all animals voices in the zoo sounds;
                6 - play an animal's voices at a specific index;
                7 - make all animals in the zoo eat;
                8 - make an animal at a specific index eat;
                9 - make all animals in the zoo show extra skill;
                10 - make an animal at a specific index show extra skill;
                11 - train all animals in the zoo;
                12 - train an animal at a specific index;
                0 - exit.
                """;
        // Scanner cs = new Scanner(System.in);
        // System.out.print(infoText);
        while (loop) {
            try {
                Scanner cs = new Scanner(System.in);
                if (zoo.zooList.size() > 0) {
                    loop = true;
                    System.out.print(infoText);
                    System.out.print("\nEnter the command or enter 0 to exit: ");
                    int myChoice = cs.nextInt();
                    switch (myChoice) {
                        case 1 -> addCreatedAnimal(zoo);
                        case 2 -> {
                            int i = inputNumber(zoo, cs);
                            System.out.printf("\n--- %s is removed from the zoo! ---\n",
                                    zoo.zooList.get(i).getClass().getSimpleName());
                            zoo.removeAnimal(i);
                        }
                        case 3 -> {
                            zoo.getAllAnimalsInfo();
                            System.out.printf("Number of animals in the Zoo: %d.\n", countt);
                        }
                        case 4 -> zoo.getAnimalInfo(inputNumber(zoo, cs));
                        case 5 -> zoo.makeAllAnimalsSound();
                        case 6 -> zoo.makeAnimalSound(inputNumber(zoo, cs));
                        case 7 -> zoo.makeAllAnimalEat();
                        case 8 -> zoo.makeAnimalEat(inputNumber(zoo, cs));
                        case 9 -> zoo.makeAllAnimalExtraDo();
                        case 10 -> zoo.makeAnimalExtraDo(inputNumber(zoo, cs));
                        case 11 -> zoo.makeAllAnimalTrain();
                        case 12 -> zoo.makeAnimalTrain(inputNumber(zoo, cs));
                        case 0 -> {
                            cs.close();
                            loop = false;
                        }
                        default -> System.out.println("you entered the wrong command. Choose command from the above list.");
                    }
                } else {
                    loop = true;
                    System.out.print(
                            "\nThe zoo is empty, the only thing you can do is to add an animal or quit:\n1 - create and add an animal;\n0 - exit.");
                    System.out.print("\nEnter the command or enter 0 to exit: ");
                    int myChoice = cs.nextInt();
                    switch (myChoice) {
                        case 1 -> addCreatedAnimal(zoo);
                        case 0 -> {
                            // cs.close();
                            loop = false;
                        }
                        default ->
                            System.out.println("you entered the wrong command. Choose command from the above list.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int inputNumber(Zoo zoo, Scanner cs) {
        int indexLength = zoo.zooList.size();
        System.out.printf("Enter the index from 0 to %d: ", indexLength - 1);
        int index = cs.nextInt();
        return index;
    }

    public void addCreatedAnimal(Zoo zoo) {
        CountAnimals countAnimals = new CountAnimals();
        try (countAnimals) {
            // countAnimals.add();
            CreaterAnimal ca = new CreaterAnimal();
            boolean cycle = true;
            Scanner cs = new Scanner(System.in);
            System.out.print("""
                    Choose an animal to create:
                    0 - exit;
                    1 - cat;
                    2 - dog;
                    3 - humster;
                    4 - horse;
                    5 - donkey;
                    6 - camel;
                    """);
            while (cycle) {
                System.out.print("\nEnter animal's number to create or enter 0 to quit the animal-creater menu: ");
                int num = cs.nextInt();
                switch (num) {
                    case 0 -> {
                        cycle = false;
                        // cs.close();
                    }
                    case 1 -> {
                        zoo.addAnimal(ca.animalCreater("cat"));
                        countAnimals.add();
                    }
                    case 2 -> {
                        zoo.addAnimal(ca.animalCreater("dog"));
                        countAnimals.add();
                    }
                    case 3 -> {
                        zoo.addAnimal(ca.animalCreater("humster"));
                        countAnimals.add();
                    }
                    case 4 -> {
                        zoo.addAnimal(ca.animalCreater("horse"));
                        countAnimals.add();
                    }
                    case 5 -> {
                        zoo.addAnimal(ca.animalCreater("donkey"));
                        countAnimals.add();
                    }
                    case 6 -> {
                        zoo.addAnimal(ca.animalCreater("camel"));
                        countAnimals.add();
                    }
                    default -> System.out.println("You entered the wrong number. Try again: ");
                }
                System.out.println("\n+++ A new animal is succesfully created and added to the zoo! +++");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
