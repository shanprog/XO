package io.hexlet.java.m101.xo;

import io.hexlet.java.m101.xo.controller.Game;
import io.hexlet.java.m101.xo.view.AdvConsoleView;
import io.hexlet.java.m101.xo.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        final Game game = new Game();

        final ConsoleView consoleView = new ConsoleView(game);
        final AdvConsoleView advConsoleView = new AdvConsoleView(game);

        startGame(advConsoleView);
    }

    private static void startGame(final ConsoleView consoleView) {
        consoleView.showGameName();
    }
}
