package animal_registry.Classes;

public class Donkey extends PackAnimal{

    boolean trained = false;
    public Donkey(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("ia-ia");
    }

    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can give you a ride");
        }
        else
            System.out.println("Donkey " + getName() + " look at you angry");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Donkey " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
