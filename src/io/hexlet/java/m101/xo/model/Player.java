package io.hexlet.java.m101.xo.model;

public class Player {

    private final String name;
    private final Figure figure;

    public Player(String name, Figure figure) {
        assert name != null;
        assert figure != null;

        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }

    public Figure getFigure() {
        return figure;
    }
}
