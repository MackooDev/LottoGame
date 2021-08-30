package input;

import lotto.input.LottoInputReceiver;
import lotto.input.NotANumberException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;



class LottoInputReceiverTest implements SampleScanner{

    LottoInputReceiver lottoInputReceiver = new LottoInputReceiver();

    @Test

    void should_return_give_number_in_set_all_in_range_1_100(){
        //given
        Set<Integer> expectedNumber = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        String givesNumber = "1, 2, 3, 4, 5, 6";
        Scanner userNumbers = createSampleScanner(givesNumber);
        //when
        final Set<Integer> userInputsNumbers = lottoInputReceiver.getSixNumbers(userNumbers);
        //then
        assertThat(expectedNumber).isEqualTo(userInputsNumbers);
    }

    @Test
    void should_throw_NotANumbersException_When_String_Was_Given(){
        //given
        String givenInput = "thdstrg";
        String expectedExceptionMessage = "Not a number was given";
        Scanner scanner = mockScannerIn(givenInput);
        //when
        Throwable throwable = catchThrowable(() -> lottoInputReceiver.getSixNumbers(scanner));
        //then
        assertThat(throwable).isInstanceOf(NotANumberException.class)
                .hasMessageContaining(expectedExceptionMessage);
    }

    private Scanner mockScannerIn(String date){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }








}

