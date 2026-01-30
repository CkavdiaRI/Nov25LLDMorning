package Module3.TicTacToe.controller;

import Module3.TicTacToe.models.Game;
import Module3.TicTacToe.models.Player;
import Module3.TicTacToe.strategies.winningStrategy.IWinningStrategy;

import java.util.List;

public class GameController {
    Game game;

    public Game startNewGame(int size, List<Player> players, List<IWinningStrategy> winningStrategies){
        this.game = new Game(size, players, winningStrategies);
        return this.game;
    }

    // Display Board
    public void displayBoard(){
        this.game.displayBoard();
    }

    // Make a move
        // Make a move
        // Check for winner after every move
        // Display Board
    public void makeMove(){
        this.game.makeMove();
    }
}


// Use case :
//Start new game
// make move
// Display board
// Choose Bot or Human
// check the winner

// Undo and Redo move
// state of the game
// Exit/Terminate the game
// Rematch with same player