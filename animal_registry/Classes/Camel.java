package animal_registry.Classes;

public class Camel extends PackAnimal{

    boolean trained = false;
    public Camel(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("cha-cha-cha");
    }

    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can give you a ride");
        }
        else
            System.out.println("Camel " + getName() + " spits on you");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Camel " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
