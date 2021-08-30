package lotto.model;

import lombok.Data;
import lotto.message.LottoMessageProvided;
import model.GameResultInfo;

import java.util.Set;

@Data
public class LottoGameResultInfo implements GameResultInfo {
    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;


    @Override
    public String getGameResultMessage() {
        return String.format(LottoMessageProvided.LOTTO_RESULT, finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
