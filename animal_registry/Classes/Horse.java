package animal_registry.Classes;

public class Horse extends PackAnimal{

    boolean trained = false;
    public Horse(String name, String birthday) {
        super(name, birthday);
    }

    @Override
    public void voice() {
        System.out.println("neigh-neigh");
    }


    @Override
    public void extraDo(){
        if(isTrained()){
            System.out.println(getName() + " can give you a ride");
        }
        else
            System.out.println("Horse " + getName() + " just gallops");
    }

    @Override
    public void train() {
        boolean t = true;
        setTrained(t);
        System.out.println("Horse " + getName() + " is trained now");
    }

    @Override
    public String toString() {
        return "name: " + super.getName() + ", birthday: " + super.getBirthday() + ", is trained: " + super.isTrained() + ',' +
        "\nskills: make voice, eat, special skill after being trained;";
    }
}
