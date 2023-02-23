package animal_registry.Classes;

public abstract class Animal {
    private boolean trained;
    private String name;
    private String birthday; // format(dd.mm.yyyy)

    public Animal(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.trained = false;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean isTrained() {
        return this.trained;
    }

    public void voice(){
        System.out.println("says");
    }

    public void eat(){
        System.out.println("am-niam-niam");
    }

    public void extraDo(){
        System.out.println("can do");
    }

    public void train(){
        boolean t = true;
        setTrained(t);
    }

    public void setTrained(boolean trained) {
        this.trained = true;
    }

    @Override
    public String toString() {
        return "name: " + name + ", birthday: " + birthday + ", is trained: " + trained +
        ',' + "\nskills: make voice, eat, special skill after being trained;";
    }
}
