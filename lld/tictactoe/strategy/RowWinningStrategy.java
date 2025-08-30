package lld.tictactoe.strategy;

import lld.tictactoe.Board;
import lld.tictactoe.Move;
import lld.tictactoe.Player;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean isPlayerWon(Player player, Board board, Move lastMove) {
        int row = lastMove.getRow();
        for (int j = 0; j < board.getSize(); j++) {
            if (board.getCells()[row][j].getSymbol() == null ||
                    board.getCells()[row][j].getSymbol() != player.getSymbol()) return false;
        }
        return true;
    }
}