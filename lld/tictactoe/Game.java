package lld.tictactoe;

import lld.tictactoe.strategy.ColumnWinningStrategy;
import lld.tictactoe.strategy.DiagonalWinningStrategy;
import lld.tictactoe.strategy.RowWinningStrategy;
import lld.tictactoe.strategy.WinningStrategy;

import java.util.*;

class Game {
    Board board;
    List<Player> players;
    Player winner;
    GameState state;
    int currentTurn;
    Stack<Move> moves;
    Stack<Move> redoMoves;
    List<WinningStrategy> strategies;

    Game(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.state = GameState.NOT_STARTED;
        this.currentTurn = new Random().nextInt(players.size()); // random first player
        this.moves = new Stack<>();
        this.redoMoves = new Stack<>();
        this.strategies = Arrays.asList(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }

    void start() {
        state = GameState.IN_PROGRESS;
    }

    boolean makeMove(int row, int col) {
        if (state != GameState.IN_PROGRESS) {
            System.out.println("Game not in progress!");
            return false;
        }

        Player currentPlayer = players.get(currentTurn);
        if (!board.cells[row][col].isEmpty()) {
            System.out.println("Cell already filled!");
            return false;
        }

        board.cells[row][col].symbol = currentPlayer.symbol;
        Move move = new Move(row, col, currentPlayer);
        moves.push(move);
        redoMoves.clear(); // invalidate redo stack

        board.printBoard();

        // Check winner
        for (WinningStrategy strategy : strategies) {
            if (strategy.isPlayerWon( currentPlayer, board, move)) {
                state = GameState.WON;
                winner = currentPlayer;
                System.out.println("Winner is: " + currentPlayer.name);
                return true;
            }
        }

        // Check draw
        if (moves.size() == board.size * board.size) {
            state = GameState.DRAW;
            System.out.println("Game Draw!");
            return true;
        }

        // Next turn
        currentTurn = (currentTurn + 1) % players.size();
        return true;
    }

    void undo() {
        if (moves.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        Move lastMove = moves.pop();
        board.cells[lastMove.row][lastMove.col].symbol = null;
        redoMoves.push(lastMove);
        board.printBoard();
    }

    void redo() {
        if (redoMoves.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        Move move = redoMoves.pop();
        board.cells[move.row][move.col].symbol = move.player.symbol;
        moves.push(move);
        board.printBoard();
    }
}