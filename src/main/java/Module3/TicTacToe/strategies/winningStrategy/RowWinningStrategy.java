package Module3.TicTacToe.strategies.winningStrategy;

import Module3.TicTacToe.models.Board;
import Module3.TicTacToe.models.Move;
import Module3.TicTacToe.models.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements IWinningStrategy{
    private HashMap<Integer, HashMap<Character, Integer>> rowCounts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int column = move.getCell().getColumn();

        // Check if the row exists in the map, if not, initialize it
        if(!rowCounts.containsKey(row)){
            rowCounts.put(row, new HashMap<>());
        }

        // Update the count for the player's symbol in the row
        HashMap<Character, Integer> rowMap = rowCounts.get(row);
        Symbol symbol =  move.getPlayer().getSymbol();
        Character symbolCharacter = symbol.getSymbol();
        if(!rowMap.containsKey(symbolCharacter)){
            rowMap.put(symbolCharacter, 0);
        }
        rowMap.put(symbolCharacter, rowMap.get(symbolCharacter) + 1);

        // Check for the winner
        if(rowMap.get(symbolCharacter) == board.getSize()){
            return true;
        }

        return false;
    }
}
