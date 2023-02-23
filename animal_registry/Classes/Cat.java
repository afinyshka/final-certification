package animal_registry.Classes;

public class Cat extends PackAnimal{

    boolean trained = false;
    public Cat(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("miay-miay");
    }

    // @Override
    // public void eat() {
    //     System.out.println("Cat " + getName() + " eats");
    // }

    @Override
    public void extraDo(){
        if(trained){
            System.out.println(getName() + " can walk on a rope");
        }
        else
            System.out.println("Cat " + getName() + " hisses on you");
    }

    @Override
    public void train() {
        this.trained = true;
        System.out.println("Cat " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
