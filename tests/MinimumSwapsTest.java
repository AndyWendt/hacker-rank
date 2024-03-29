import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsTest {
    @ParameterizedTest
    @MethodSource("swapsDataProvider")
    public void it_calculates_the_minimum_swaps(int expectedSwaps, int[] input) {
        int result = MinimumSwaps.minimumSwaps(input);
        assertSame(expectedSwaps, result);
    }

    @ParameterizedTest
    @MethodSource("swapsFileDataProvider")
    public void it_calculates_the_minimum_swaps_from_files(int expectedSwaps, String fileName) throws IOException {
        int[] input = readBlocksFromFile(fileName);
        int result = MinimumSwaps.minimumSwaps(input);
        assertEquals(expectedSwaps, result);
    }


    static Stream<Arguments> swapsDataProvider() {
        return Stream.of(
                // expected, input int[]
                Arguments.arguments(3, new int[] {2, 3, 4, 1, 5}),
                Arguments.arguments(3, new int[] {1, 3, 5, 2, 4, 6, 7}),
                Arguments.arguments(5, new int[] {7, 1, 3, 2, 4, 5, 6})
        );
    }

    static Stream<Arguments> swapsFileDataProvider() {
        return Stream.of(
                // expected, input int[]
                Arguments.arguments(99987, "input12.txt")
        );
    }

    private int[] readBlocksFromFile(String file) throws IOException {
        URL url = getClass().getResource("data/minimum-swaps" + file);
        Path path = Paths.get(url.getPath());
        Stream<String> stream = Files.lines(path);
        Iterator<String> iterator = stream.iterator();
        iterator.next();
        String currentLineString = iterator.next().trim();
        String[] numbers = currentLineString.split("\\s+");
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }
}