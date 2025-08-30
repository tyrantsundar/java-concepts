package lld.tictactoe.strategy;

import lld.tictactoe.Board;
import lld.tictactoe.Move;
import lld.tictactoe.Player;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean isPlayerWon(Player player, Board board, Move lastMove) {
        int col = lastMove.getCol();
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[i][col].getSymbol() == null ||
                    board.getCells()[i][col].getSymbol() != player.getSymbol()) return false;
        }
        return true;
    }
}
