package io.hexlet.java.m101.xo;

import io.hexlet.java.m101.xo.controller.GameController;
import io.hexlet.java.m101.xo.model.Board;
import io.hexlet.java.m101.xo.model.Figure;
import io.hexlet.java.m101.xo.model.Player;
import io.hexlet.java.m101.xo.view.ConsoleView;
import io.hexlet.java.m101.xo.view.MenuView;

public class Main {
    public static void main(String[] args) {

        final GameController gameController = new GameController(null,
                new Player[]{new Player("Max", new Figure("O")), new Player("Slava", new Figure("X"))}, new Board());
//
        final ConsoleView consoleView = new ConsoleView(gameController);
//        final AdvConsoleView advConsoleView = new AdvConsoleView(gameController);
//

        MenuView menu = new MenuView();
        menu.showMenuWithResult();
//        startGame(consoleView);
    }

    private static void startGame(final ConsoleView consoleView) {
        consoleView.showGameName();
        consoleView.showPlayers();
        consoleView.showBoard();
        consoleView.start();
    }
}
