package animal_registry.Classes;

public class Humster extends PackAnimal{

    boolean trained = false;
    public Humster(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("pi-pi");
    }

    // @Override
    // public void eat() {
    //     System.out.println("Humster " + getName() + " eats");
    // }

    @Override
    public void extraDo(){
        if(trained){
            System.out.println(getName() + " can spit a wheel");
        }
        else
            System.out.println("Humster " + getName() + " bites youu");
    }

    @Override
    public void train() {
        this.trained = true;
        System.out.println("Humster " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}

