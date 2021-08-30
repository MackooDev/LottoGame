package input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public interface SampleScanner {

    default Scanner createSampleScanner(String date){
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }

}

