package Module3.TicTacToe.models;

import Module3.TicTacToe.strategies.botPlayingStrategy.BotPlayingStrategyFactory;
import Module3.TicTacToe.strategies.botPlayingStrategy.IBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel level;

    public Bot(String name, Symbol symbol, BotDifficultyLevel level) {
        super(name, symbol, PlayerType.BOT);
        this.level = level;
    }

    public BotDifficultyLevel getLevel() {
        return level;
    }

    public void setLevel(BotDifficultyLevel level) {
        this.level = level;
    }

    @Override
    public Move makeMove(Board board) {
        IBotPlayingStrategy botStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(level);
        return botStrategy.makeMove(board, this);
    }
}
