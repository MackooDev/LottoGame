package lotto.input;

import lotto.message.LottoMessageProvided;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static lotto.config.LottoGameConfig.*;

public class LottoInputReceiver {

    private static final String NEGATIVE_AND_POSITIVE_NUMBER_REGEX = "^-?\\d*\\.{0,1}\\d+&";

    public Set<Integer> getSixNumbers(Scanner scanner){
        Set<Integer> givenNumbersFromUser = getNumbersFromUserInputs(scanner);
        scanner.close();
        return givenNumbersFromUser;
    }


    private Set<Integer> getNumbersFromUserInputs(Scanner in) {
        final Set<Integer> givenNumbers = new HashSet<>();
        System.out.println(String.format(LottoMessageProvided.PLEASE_GIVE_NUMBERS, HOW_MANY_GIVEN_NUMBERS_USER));
        while (areLessThanSixNumbersGiven(givenNumbers)) {
            System.out.println(LottoMessageProvided.GIVE_NUMBER);
            while (!in.hasNextInt()) {
                System.out.printf(LottoMessageProvided.NOT_IN_RANGE, LOWER_BOUNDS_NUMBER, UPPER_BOUNDS_NUMBER);
                if (!in.hasNext()) {
                    return Collections.emptySet();
                }
                String next = in.next();
                if(!next.contains(NEGATIVE_AND_POSITIVE_NUMBER_REGEX)){
                    throw new NotANumberException();
                }
            }
            final int userInput = in.nextInt();
            validateNumber(givenNumbers, userInput);
        }
        return givenNumbers;
    }



    private void validateNumber(Set<Integer> givenNumbers, int userInput) {
        if (isInRange(userInput)) {
            givenNumbers.add(userInput);
        } else {
            System.out.printf(LottoMessageProvided.NOT_IN_RANGE_WITH_GIVEN_NUMBER, userInput, LOWER_BOUNDS_NUMBER, UPPER_BOUNDS_NUMBER);
        }
    }

    private boolean areLessThanSixNumbersGiven(Set<Integer> numbers) {
        return numbers.size() < HOW_MANY_GIVEN_NUMBERS_USER;
    }

    private boolean isInRange(int givenNumber) {
        return givenNumber >= LOWER_BOUNDS_NUMBER&& givenNumber <= UPPER_BOUNDS_NUMBER;
    }
}


