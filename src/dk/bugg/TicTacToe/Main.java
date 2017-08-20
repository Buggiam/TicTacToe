package dk.bugg.TicTacToe;

public class Main {

    public static TicTacToe game;

    public static void main(String[] args) {
        System.out.println("Preparing game...");
        game = new TicTacToe();
        game.start();
    }
}