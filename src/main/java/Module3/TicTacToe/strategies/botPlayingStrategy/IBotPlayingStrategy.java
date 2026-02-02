package Module3.TicTacToe.strategies.botPlayingStrategy;

import Module3.TicTacToe.models.Board;
import Module3.TicTacToe.models.Move;
import Module3.TicTacToe.models.Player;

public interface IBotPlayingStrategy {
    public Move makeMove(Board board, Player player);
}
