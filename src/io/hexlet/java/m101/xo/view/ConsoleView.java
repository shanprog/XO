package io.hexlet.java.m101.xo.view;

import io.hexlet.java.m101.xo.controller.GameController;

public class ConsoleView {

    protected final GameController gameController;

    public ConsoleView(GameController gameController) {

        assert gameController != null;

        this.gameController = gameController;
    }

    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }
}
