package io.hexlet.java.m101.xo.model;

public class Board {

    private static final int SIZE_FIELD = 3;

    private Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public Figure getFigure(final int x, final int y) {

        assert x >= 0 && x < SIZE_FIELD;
        assert y >= 0 && y < SIZE_FIELD;

        if (checkCoordinate(x) && checkCoordinate(y))
            return figures[x][y];
        else
            return null;
    }

    boolean setFigure(final int x, final int y, final Figure figure) {

        if (checkCoordinate(x) && checkCoordinate(y)) {
            figures[x][y] = figure;
            return true;
        } else return false;

    }

    private static boolean checkCoordinate(final int coordinate) {
        if (coordinate < 0 || coordinate >= SIZE_FIELD) return false;

        return true;
    }


}
