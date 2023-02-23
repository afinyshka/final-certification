package animal_registry.Classes;

public class Dog extends DomesticAnimal{

    boolean trained = false;
    public Dog(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("vaf-vaf");
    }


    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can give you a paw");
        }
        else
            System.out.println("Dog " + getName() + " bark on you");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Dog " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
