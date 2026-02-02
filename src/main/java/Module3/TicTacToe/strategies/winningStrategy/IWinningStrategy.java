package Module3.TicTacToe.strategies.winningStrategy;

import Module3.TicTacToe.models.Board;
import Module3.TicTacToe.models.Move;

public interface IWinningStrategy {
    public boolean checkWinner(Move move, Board board);
}
