public interface Contract {

    void grab(String item);
    String drop(String item);
    void examine(String item);
    void use(String item);
    boolean walk(String direction); // done
    boolean fly(int x, int y);
    Number shrink(); // done
    Number grow(); // done
    void rest();
    void undo();

}