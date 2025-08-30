package lld.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
        public static void main(String[] args) {
            Player p1 = new Player("Alice", new Symbol('X', "RED"));
            Player p2 = new Player("Bob", new Symbol('O', "BLUE"));

            List<Player> players = Arrays.asList(p1, p2);
            Game game = new Game(3, players);

            game.start();
            game.makeMove(0, 0); // Alice/Bob random
            game.makeMove(1, 1);
            game.makeMove(0, 1);
            game.makeMove(2, 2);
            game.makeMove(0, 2); // should win by row

            game.undo();
            game.redo();

    }
}
