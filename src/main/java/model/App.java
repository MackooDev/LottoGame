package model;

import java.util.Scanner;

import lotto.Game;
import lotto.LottoGame;
import lotto.input.LottoInputReceiver;
import lotto.logic.LottoHitNumbersCalculator;
import lotto.logic.LottoRandomGenerator;


public class App {

    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.startGame();
    }

    private static Game getLottoGame() {
        final LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();
        final LottoRandomGenerator randomGenerator = new LottoRandomGenerator();
        final LottoHitNumbersCalculator lottoHitNumberCalculator = new LottoHitNumbersCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new LottoGame(lottoInputReceiver, randomGenerator, lottoHitNumberCalculator, scanner);
    }
}
