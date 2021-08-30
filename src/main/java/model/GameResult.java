package model;


import lombok.Data;
import lotto.Game;

@Data
public class GameResult {

    private final Game game;
    private final GameResultInfo gameResultInfo;
}
