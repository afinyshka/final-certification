package animal_registry.Classes;

public class Cat extends DomesticAnimal{

    boolean trained = false;
    public Cat(String name, String birthday) {
        super(name, birthday);

    }

    @Override
    public void voice() {
        System.out.println("miay-miay");
    }

    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can walk on a rope");
        }
        else
            System.out.println("Cat " + getName() + " hisses on you");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Cat " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
