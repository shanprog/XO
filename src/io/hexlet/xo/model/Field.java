package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;
    private final int field_size;

    private final Figure[][] field;

    public Field(int field_size) {
        this.field_size = field_size;
        field = new Figure[this.field_size][this.field_size];
    }

    public int getSize() {
        return field_size;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException, AlreadyOccupiedException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}