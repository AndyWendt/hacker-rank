import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsTest {
    @ParameterizedTest
    @MethodSource("swapsDataProvider")
    public void it_calculates_the_minimum_swaps(int expectedSwaps, int[] input) {
        int result = MinimumSwaps.minimumSwaps(input);
        assertSame(expectedSwaps, result);
    }

    static Stream<Arguments> swapsDataProvider() {
        return Stream.of(
                // expected, input int[]
                Arguments.arguments(3, new int[] {2, 3, 4, 1, 5}),
                Arguments.arguments(3, new int[] {1, 3, 5, 2, 4, 6, 7})
        );
    }
}