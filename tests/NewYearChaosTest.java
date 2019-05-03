import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NewYearChaosTest {

    @ParameterizedTest
    @MethodSource("swapsFileDataProvider")
    public void readBlocksFromFile(String inputFile, String outputFile) throws IOException {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Iterator<String> inputIterator = getFileStringIterator(inputFile);
        Iterator<String> outputIterator = getFileStringIterator(outputFile);
        int numberOfPairs = Integer.parseInt(inputIterator.next());

        for (int i = 0; i < numberOfPairs; i++) {
            String lineLength = inputIterator.next().trim();
            String currentLineString = inputIterator.next().trim();
            String[] numbers = currentLineString.split("\\s+");
            int[] numberArray = Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
            NewYearChaos.minimumBribes(numberArray);

            String expected = outputIterator.next();
            String result = baos.toString();
            assertEquals(expected, result);
            baos.reset();
        }


        System.setOut(oldOut);
    }

    private Iterator<String> getFileStringIterator(String file) throws IOException {
        URL url = getClass().getResource("data/" + file);
        Path path = Paths.get(url.getPath());
        Stream<String> stream = Files.lines(path);
        return stream.iterator();
    }

    static Stream<Arguments> swapsFileDataProvider() {
        return Stream.of(
                // expected, input int[]
                Arguments.arguments("new-year-chaos/input00.txt", "new-year-chaos/output00.txt"),
                Arguments.arguments("new-year-chaos/input01.txt", "new-year-chaos/output01.txt"),
                Arguments.arguments("new-year-chaos/input11.txt", "new-year-chaos/output11.txt")
        );
    }
}
