package io.hexlet.java.m101.xo.controller;

import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;

public class GameController {

    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 2;

    private final Board board;
    private final String gameName;

    private Player[] players = new Player[2];

    public GameController(final String gameName, final Player[] players, final Board board) {
        if (gameName == null || gameName.isEmpty())
            this.gameName = "XO";
        else
            this.gameName = gameName;

        this.players = players;

        this.board = board;
        board.setFigure(1, 1, new Figure("X"));
    }

    public Board getBoard() {
        return board;
    }

    public String getGameName() {
        return gameName;
    }

    public boolean move(final int x, final int y) {

        assert x >= 0;
        assert y >= 0;

        if (!checkCoordinate(x) || !checkCoordinate(y)) {
            return false;
        }

        // TODO logic fo move

        return true;
    }

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < MIN_COORDINATE || coordinate > MAX_COORDINATE) return false;

        return true;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player winner() {

        // Проверка рядов на выигрыш
        int winX = 0;
        int winO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getFigure(i, j) != null) {
                    if (board.getFigure(i, j).getFigure().equals("X")) {
                        winX++;
                    } else
                        winO++;
                }
            }

            if (winX == 3)
                for (Player player : players) {
                    if (player.getFigure().getFigure().equals("X"))
                        return player;
                }
            else if (winO == 3)
                for (Player player : players) {
                    if (player.getFigure().getFigure().equals("O"))
                        return player;
                }

        }

        // Проверка столбцов на выигрыш
        winX = 0;
        winO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getFigure(j, i) != null) {
                    if (board.getFigure(j, i).getFigure().equals("X")) {
                        winX++;
                    } else
                        winO++;
                }
            }

            if (winX == 3)
                for (Player player : players) {
                    if (player.getFigure().getFigure().equals("X"))
                        return player;
                }
            else if (winO == 3)
                for (Player player : players) {
                    if (player.getFigure().getFigure().equals("O"))
                        return player;
                }

        }


        // Проверка диагоналей на выигрыш

        winX = 0;
        winO = 0;

        for (int i = 0; i < 3; i++) {
            if (board.getFigure(i, i) != null) {
                if (board.getFigure(i, i).getFigure().equals("X")) {
                    winX++;
                } else
                    winO++;
            }
        }

        if (winX == 3)
            for (Player player : players) {
                if (player.getFigure().getFigure().equals("X"))
                    return player;
            }
        else if (winO == 3)
            for (Player player : players) {
                if (player.getFigure().getFigure().equals("O"))
                    return player;
            }

        winX = 0;
        winO = 0;
        int adder = 2;

        for (int i = 0; i < 3; i++) {
            if (board.getFigure(i, adder) != null) {
                if (board.getFigure(i, i).getFigure().equals("X")) {
                    winX++;
                } else
                    winO++;
            }
            adder--;
        }

        if (winX == 3)
            for (Player player : players) {
                if (player.getFigure().getFigure().equals("X"))
                    return player;
            }
        else if (winO == 3)
            for (Player player : players) {
                if (player.getFigure().getFigure().equals("O"))
                    return player;
            }

        return null;
    }


    public Player currentPlayer() {

        int countX = 0;
        int countO = 0;

        for (int i = 0; i < Board.SIZE_FIELD; i++) {
            for (int j = 0; j < Board.SIZE_FIELD; j++) {

                if (board.getFigure(i, j) != null) {
                    if (board.getFigure(i, j).getFigure().equals("X")) {
                        countX++;
                    } else if (board.getFigure(i, j).getFigure().equals("O")) {
                        countO++;
                    }
                }

            }
        }

        Player currentPlayer = null;

        if (countX == countO || countX == 0) {
            for (Player player : players) {
                if (player.getFigure().getFigure().equals("X"))
                    currentPlayer = player;
            }
        } else {
            for (int i = 0; i < players.length; i++) {
                if (players[i].getFigure().getFigure().equals("O"))
                    currentPlayer = players[i];
            }
        }

        return currentPlayer;
    }


}
