package Module3.TicTacToe.models;

import Module3.TicTacToe.strategies.winningStrategy.IWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<IWinningStrategy> winningStrategies;

    public Game(int size, List<Player> players, List<IWinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
        this.winner = null;
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<IWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<IWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    // Display Board
    public void displayBoard(){
        board.displayBoard();
    }

    boolean validate(Move move){
        // Validate the move
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()){
            return false;
        }

        return move.getCell().getCellState().equals(CellState.EMPTY);
    }

    public void updateGameAfterValidMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getColumn();

        // Update the cell state on the board
        Cell cellToBeUpdated = move.getCell();
        cellToBeUpdated.setCellState(CellState.OCCUPIED);
        cellToBeUpdated.setPlayer(move.getPlayer());
        cellToBeUpdated.setSymbol(move.getPlayer().getSymbol());

        // Update the moves list
        moves.add(move);

        // Update next player index
        nextPlayerIndex++;
        nextPlayerIndex = nextPlayerIndex % players.size();
    }

    // Make a move
    public void makeMove(){
        // Current p[layer
        Player currentPlayer = players.get(nextPlayerIndex);
        System.out.println(currentPlayer.getName() + ", it's your turn. Please be ready !");

        Move move = currentPlayer.makeMove();

        // Validate the move
        if(validate(move)){
            updateGameAfterValidMove(move);
        }


        // Update the board with the validated move
        moves.add(move);


        // Check for the winner

    }
}
