package lotto.logic;

import java.security.SecureRandom;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.config.LottoGameConfig.*;

public class LottoRandomGenerator {
    public Set<Integer> getRandomSixNumbers(){
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.ints(NUMBERS_TO_GENERATE, NUMBER_ORIGIN, RANDOM_NUMBER_BOUND)
                .boxed()
                .collect(Collectors.toSet());
    }
}
