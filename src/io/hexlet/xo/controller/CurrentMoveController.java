package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigures = 0;

        for (int x = 0; x < field.getSize(); x++) {
            countFigures+=countFiguresInRow(field, x);
        }

        if (countFigures == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigures % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;
    }

    private int countFiguresInRow(final Field field, int row) {
        int countFigures = 0;

        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) {
                    countFigures++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }

        return countFigures;
    }
}
