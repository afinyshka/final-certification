package animal_registry.Classes;

public class Dog extends PackAnimal{

    boolean trained = false;
    public Dog(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("vaf-vaf");
    }

    // @Override
    // public void eat() {
    //     System.out.println("Dog " + getName() + " eats");
    // }

    @Override
    public void extraDo(){
        if(trained){
            System.out.println(getName() + " can give you a paw");
        }
        else
            System.out.println("Dog " + getName() + " bark on you");
    }

    @Override
    public void train() {
        this.trained = true;
        System.out.println("Dog " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
