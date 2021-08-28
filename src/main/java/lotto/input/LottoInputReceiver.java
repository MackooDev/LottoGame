package lotto.input;

import lotto.message.LottoMessageProvided;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoInputReceiver {

    public Set<Integer> getSixNumbers(Scanner scanner){
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInputs(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }

    public Set<Integer> getNumbersFromUserInputs(){
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessageProvided.PLEASE_GIVE_NUMBERS, ));

    }

}
