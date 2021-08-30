package lotto;


import lombok.Data;
import lotto.Game;
import lotto.input.LottoInputReceiver;
import lotto.logic.LottoHitNumbersCalculator;
import lotto.logic.LottoRandomGenerator;
import lotto.message.LottoMessageProvided;
import model.GameResult;
import model.GameResultInfo;

import java.util.Scanner;
import java.util.Set;

import static lotto.message.LottoMessageProvided.GAME_NAME;

@Data
public class LottoGame implements Game {

    private final LottoInputReceiver lottoInputReceiver;
    private final LottoRandomGenerator randomGenerator;
    private final LottoHitNumbersCalculator lottoHitNumberCalculator;
    private final Scanner scanner;


    public GameResult startGame() {
        System.out.println(String.format(LottoMessageProvided.GAME_S_STARTED, GAME_NAME));
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }

    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = lottoInputReceiver.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = randomGenerator.getRandomSixNubers();
        return lottoHitNumberCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }

    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        System.out.println(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }

}
