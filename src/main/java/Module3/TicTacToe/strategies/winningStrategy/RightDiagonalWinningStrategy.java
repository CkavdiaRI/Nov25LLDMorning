package Module3.TicTacToe.strategies.winningStrategy;

import Module3.TicTacToe.models.Board;
import Module3.TicTacToe.models.Move;

public class RightDiagonalWinningStrategy implements IWinningStrategy{
    @Override
    public boolean checkWinner(Move move, Board board) {
        return false;
    }
}
