package animal_registry.Classes;

public class Humster extends DomesticAnimal{

    boolean trained = false;
    public Humster(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("pi-pi");
    }

    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can spin a wheel");
        }
        else
            System.out.println("Humster " + getName() + " bites you");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Humster " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}

