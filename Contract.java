public interface Contract {

    void grab(String item); // done
    String drop(String item);
    void examine(String item);
    void use(String item);
    boolean walk(String direction); // done
    boolean fly(int x, int y);
    Number shrink(); // done
    Number grow(); // done
    void rest(); // done
    void undo();

}