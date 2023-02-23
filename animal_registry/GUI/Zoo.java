package animal_registry.GUI;

import java.util.ArrayList;

import animal_registry.Classes.Animal;

public class Zoo {
    ArrayList<Animal> zooList;
    String noText = "There is no animal with given index = ";

    public Zoo() {
        this.zooList = new ArrayList<>();
    }

    public void addAnimal(Animal... args) { // add few Animal
        for (Animal a : args) {
            this.zooList.add(a);
        }
    }

    public void removeAnimal(int index) {
        if (index < this.zooList.size()) {
            this.zooList.remove(index);
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void getAnimalInfo(int index) {
        if (index < this.zooList.size()) {
            System.out.printf(" %s's info:\n", this.zooList.get(index).getClass().getSimpleName());
            System.out.println(this.zooList.get(index).toString());
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void makeAnimalSound(int index) {
        if (index < this.zooList.size()) {
            System.out.printf(" %s says:\n", this.zooList.get(index).getClass().getSimpleName());
            this.zooList.get(index).voice();
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void makeAnimalEat(int index) {
        if (index < this.zooList.size()) {
            System.out.printf(" %s eats:\n", this.zooList.get(index).getClass().getSimpleName());
            this.zooList.get(index).eat();
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void makeAnimalTrain(int index) {
        if (index < this.zooList.size()) {
            // System.out.printf(" %s says:\n", this.zooList.get(index).getClass().getSimpleName());
            this.zooList.get(index).train();
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void makeAnimalExtraDo(int index) {
        if (index < this.zooList.size()) {
            // System.out.printf(" %s says:\n", this.zooList.get(index).getClass().getSimpleName());
            this.zooList.get(index).extraDo();
        } else {
            System.out.printf(noText + "%d\n", index);
        }
    }

    public void getAllAnimalsInfo() {
        System.out.println("   Zoo info:");
        for (int i = 0; i < this.zooList.size(); i++) {
            getAnimalInfo(i);
        }
    }

    public void makeAllAnimalsSound() {
        System.out.println("   Zoo sounds:");
        for (Animal item : this.zooList) {
            item.voice();
        }
    }

    public void makeAllAnimalEat() {
        System.out.println("   Zoo eats:");
        for (int i = 0; i < this.zooList.size(); i++)  {
            makeAnimalEat(i);
        }
    }

    public void makeAllAnimalTrain() {
        System.out.println("   Zoo trains:");
        for (int i = 0; i < this.zooList.size(); i++)  {
            makeAnimalTrain(i);
        }
    }

    public void makeAllAnimalExtraDo() {
        System.out.println("   Zoo shows extra skills:");
        for (int i = 0; i < this.zooList.size(); i++)  {
            makeAnimalExtraDo(i);
        }
    }
}