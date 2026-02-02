package Module3.TicTacToe.strategies.botPlayingStrategy;

import Module3.TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static IBotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel level) {
        if(level == BotDifficultyLevel.EASY) {
            return new EasyBotPlayingStrategy();}
//        } else if(level == BotDifficultLevel.MEDIUM) {
//            return new MediumBotPlayingStrategy();
//        } else if(level == BotDifficultLevel.HARD) {
//            return new HardBotPlayingStrategy();
//        }
        return null;
    }
}
