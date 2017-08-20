package dk.bugg.TicTacToe;

public class Board {

    private int[][] values = {{0,0,0}, {0,0,0}, {0,0,0}};
    private String lineSplit = "  --- --- ---";

    private int winner = 0;

    public Board() {

    }

    public void print() {
        System.out.println(lineSplit);
        for (int r = 0; r < 3; r++) {
            System.out.print(" | ");
            for (int c = 0; c < 3; c++) {
                System.out.print(getSymbol(values[r][c]));
                System.out.print(" | ");
            }

            System.out.println();
            System.out.println(lineSplit);
        }
    }

    public boolean set(int r, int c, int type) {
        r--;
        c--;

        try {
            if (values[r][c] != 0)
                return false;
            values[r][c] = type;
            winnerCheck();

            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public void clear() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                values[r][c] = 0;

        winner = 0;
    }

    public int getWinner() {
        return winner;
    }

    private String getSymbol(int i) {
        switch(i) {
            case 1:
                return "X";
            case 2:
                return "O";
        }

        return " ";
    }

    private void winnerCheck() {
        if (isFull())
            winner = 3;

        for (int p = 1; p < 3; p++) {
            if (hasWon(p))
                winner = p;
        }
    }

    private boolean hasWon(int p) {
        if (values[0][0] == p && values[0][1] == p && values[0][2] == p) //UP ROW
            return true;
        if (values[1][0] == p && values[1][1] == p && values[1][2] == p) //MID ROW
            return true;
        if (values[2][0] == p && values[2][1] == p && values[2][2] == p) //BUT ROW
            return true;

        if (values[0][0] == p && values[1][0] == p && values[2][0] == p) //LEFT COLUMN
            return true;
        if (values[0][1] == p && values[1][1] == p && values[2][1] == p) //MID COLUMN
            return true;
        if (values[0][2] == p && values[1][2] == p && values[2][2] == p) //RIGHT COLUMN
            return true;

        if (values[0][0] == p && values[1][1] == p && values[2][2] == p) //UP LEFT-DOWN RIGHT
            return true;
        if (values[2][0] == p && values[1][1] == p && values[0][2] == p) //DOWN LEFT-UP RIGHT
            return true;

        return false;
    }

    private boolean isFull() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (values[r][c] == 0)
                    return false;

        return true;
    }
}
