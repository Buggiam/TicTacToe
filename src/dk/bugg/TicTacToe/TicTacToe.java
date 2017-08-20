package dk.bugg.TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private Board board;
    private int turn;

    private Scanner scanner;

    public TicTacToe() {
        this.board = new Board();
        turn = 1;
        scanner = new Scanner(System.in);
    }

    public void reset() {
        board.clear();
        turn = 1;
    }

    public void start() {
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("WELCOME TO TICTACTOE!");
        board.print();

        while(board.getWinner() == 0) {
            if (nextTurn()) {
                if (turn == 1)
                    turn = 2;
                else
                    turn = 1;
            }
            board.print();
        }

        if (board.getWinner() == 1 || board.getWinner() == 2)
            System.out.println("PLAYER #" + board.getWinner() + " WINS!");
        else
            System.out.println("You ran out of space.");

        System.out.println("Press ENTER to start a new game...");
        scanner.nextLine();
        reset();
        start();
    }

    private boolean nextTurn() {
        System.out.println("Player #" + turn + ", enter your move (row[1-3] column[1-3]): ");
        String input = scanner.nextLine();

        if (!input.matches("[1-3] [1-3]"))
            return false;

        int r = Integer.parseInt(input.split(" ")[0]);
        int c = Integer.parseInt(input.split(" ")[1]);

        if (!board.set(r, c, turn)) {
            System.out.println("That spot has already been taken.");
            return false;
        }

        return true;
    }
}
