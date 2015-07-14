package io.hexlet.java.m101.xo.view;

import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private static final String LINE_CHARACTER = "~";
    private static final int LINE_SIZE = 12;
    protected final GameController gameController;

    public ConsoleView(GameController gameController) {

        assert gameController != null;

        this.gameController = gameController;
    }

    public void start() {
        System.out.println("Please, input coordinates");
        int x = getCoordinate("X");
        int y = getCoordinate("Y");
    }

    public void showBoard() {
        for (int i = 0; i < 3; i++)
            showBoardLine(i);
    }

    private void showBoardLine(final int row) {
        for (int i = 0; i < 3; i++)
            System.out.print(gameController.getBoard().getFigure(row, i));

        System.out.println();
        showLine(LINE_SIZE);
    }

    private void showLine(int size) {
        for (int i = 0; i < size; i++)
            System.out.print(LINE_CHARACTER);
        System.out.println();
    }

    public void showPlayers() {
        for (Player player : gameController.getPlayers()) {
            System.out.println(player.getName());
        }
    }


    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }

    private int getCoordinate(final String coordinateName) {

        int counter = 0;
        do {
            System.out.print(String.format("Input the coordinate %s: ", coordinateName));
            try {
                final Scanner in = new Scanner(System.in);
                return in.nextInt();
            } catch (final InputMismatchException ime) {
                System.out.println("Coordinate is incorrect");
            }
        } while (counter++ < 2);

        return -1;
    }
}
