package lld.tictactoe.strategy;

import lld.tictactoe.Board;
import lld.tictactoe.Move;
import lld.tictactoe.Player;

public interface WinningStrategy {
    public boolean isPlayerWon(Player player, Board board, Move move);
}
