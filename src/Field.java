import java.io.IOException;
import java.util.Random;
import java.io.Console;


public class Field{
    private char[][] field;
    private char[][] previousField;
    private int fieldWidth;
    private int fieldHeight;

    public void setInitialState(int numberOfAnimals, int fieldHeight, int fieldWidth){
        this.fieldHeight = fieldHeight;
        this.fieldWidth = fieldWidth;


        this.field = new char[fieldHeight][fieldWidth];

        for (int i = 0; i < fieldHeight; ++i)
            for (int j =0; j < fieldWidth; ++j)
                field[i][j] = ' ';


        Random random = new Random(fieldHeight *fieldWidth - 1);

        int initiatedFields = 0;

        while (initiatedFields != numberOfAnimals){
            int currentPoint = Math.abs(random.nextInt() % ( fieldWidth * fieldHeight));

            int x = currentPoint / fieldWidth;
            int y = currentPoint % fieldWidth;

            if (field[x][y] == 'x')
                continue;
            else
                field[x][y] = 'x';

            initiatedFields++;
        }
    }

    public void makeNextMove(){
        this.previousField = new char[fieldHeight + 2][fieldWidth + 2];
        fillPreviousField();

    };

    private void fillPreviousField(){

        previousField[0][0] = ' ';
        previousField[0][fieldWidth + 1] = ' ';
        previousField[fieldHeight + 1][0] = ' ';
        previousField[fieldHeight + 1][fieldWidth + 1] = ' ';

        for (int i = 1; i < fieldWidth + 1; ++i)
            previousField[0][i] = field [fieldHeight - 1][i - 1];

        for (int i = 1; i < fieldWidth + 1; ++i)
            previousField[fieldHeight + 1][i] = field [0][i - 1];


        for (int i = 1; i < fieldHeight + 1; ++i)
            previousField[i][0] = field[i - 1][fieldWidth - 1];

        for (int i = 1; i < fieldHeight + 1; ++i)
            previousField[i][fieldWidth + 1] = field[i - 1][0];

        for (int i = 1; i < fieldHeight + 1; ++i)
            for (int j = 1; j < fieldWidth + 1; ++j)
                previousField[i][j] = field[i - 1][j - 1];
    }

    public void drawField() {
        for (int i = 0; i < fieldHeight; ++i) {
            for (int j = 0; j < fieldWidth; ++j)
                System.out.print(field[i][j]);
            System.out.println();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPreviousField() {
        for (int i = 0; i < fieldHeight + 2; ++i) {
            for (int j = 0; j < fieldWidth + 2; ++j)
                System.out.print(previousField[i][j]);
            System.out.println();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
