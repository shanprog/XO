package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {
        try {

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), point -> new Point(point.x, point.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), point -> new Point(point.x + 1, point.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }

            if (check(field, new Point(0, 0), point -> new Point(point.x + 1, point.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(0, 2), point -> new Point(point.x + 1, point.y - 1))) {
                return field.getFigure(new Point(0, 0));
            }


        } catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Field field, final Point currentPoint, final IPointChanger pointChanger) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointChanger.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);

            if (currentFigure == null)
                return false;

        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure)
            return false;


        return check(field, nextPoint, pointChanger);
    }


    private interface IPointChanger {
        Point next(final Point point);
    }
}
