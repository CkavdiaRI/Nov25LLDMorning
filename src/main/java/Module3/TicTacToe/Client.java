package Module3.TicTacToe;

import Module3.TicTacToe.controller.GameController;
import Module3.TicTacToe.models.*;
import TicTacToe.models.*;
import Module3.TicTacToe.strategies.winningStrategy.IWinningStrategy;
import Module3.TicTacToe.strategies.winningStrategy.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        int size = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Human("Player 1", new Symbol('X'), 1));
        players.add(new Bot("Player 2", new Symbol('O'), BotDifficultyLevel.EASY));

        List<IWinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());

        Game game = gameController.startNewGame(size, players, winningStrategies);

        gameController.displayBoard();

        // Play the game
        while(gameController.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.makeMove();
            gameController.displayBoard();
        }

        // Display the results
        if(gameController.getGameState().equals(GameState.SUCCESS)) {
            System.out.println("Game Over! The winner is: " + gameController.checkWinner().getName());
        } else if (gameController.getGameState().equals(GameState.DRAW)) {
            System.out.println("Game Over! It's a draw.");
        }

    }
}
