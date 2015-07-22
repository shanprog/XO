package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {
    public static void main(String[] args) {
        final String name1 = "Gleb";
        final String name2 = "Slava";

        final Field field = new Field(3);

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        Game gameXo = new Game(players, field, "XOCLI");

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(gameXo);
        while (consoleView.move(gameXo)) {
            consoleView.show(gameXo);
        }

    }
}
