
public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        field.setInitialState(16, 10, 10);

        while (true) {
            field.drawField();
            field.makeNextMove();
        }
    }
}
