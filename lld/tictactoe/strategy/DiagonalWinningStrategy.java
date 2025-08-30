package lld.tictactoe.strategy;

import lld.tictactoe.Board;
import lld.tictactoe.Move;
import lld.tictactoe.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean isPlayerWon(Player player, Board board, Move move) {
        boolean mainDiag = true, antiDiag = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCells()[i][i].getSymbol() == null ||
                    board.getCells()[i][i].getSymbol() != player.getSymbol()) mainDiag = false;
            if (board.getCells()[i][board.getSize() - i - 1].getSymbol() == null ||
                    board.getCells()[i][board.getSize() - i - 1].getSymbol() != player.getSymbol()) antiDiag = false;
        }
        return mainDiag || antiDiag;
    }
}
