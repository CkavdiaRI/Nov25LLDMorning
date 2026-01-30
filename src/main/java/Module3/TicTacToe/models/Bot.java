package Module3.TicTacToe.models;

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
    public Move makeMove() {
        // Bot move logic can be implemented here
        return null;
    }
}
