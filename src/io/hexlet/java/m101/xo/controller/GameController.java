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

    public Player currentPlayer() {
        return null;
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
}
