package animal_registry.GUI;


public class CountAnimals implements AutoCloseable {
    boolean isClosed;
    static int countt = 0;

    CountAnimals() {
        isClosed = false;
    }


    public void add() {
        if (isClosed) {
            throw new RuntimeException();
        }
        countt++;
    }

    @Override
    public void close() throws Exception {
        this.isClosed = true;
    }
}