import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoDArrayTest {

    @ParameterizedTest
    @MethodSource("hourglassSumDataProvider")
    public void it_completes_an_hourglass_sum(int expectedMaxSum, int[][] hourglassArray) {
        int result = TwoDArray.hourglassSum(hourglassArray);
        assertSame(expectedMaxSum, result);
    }

    static Stream<Arguments> hourglassSumDataProvider() {
        return Stream.of(
                // expected
                arguments(19, new int[][] {
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0},
                }),
                arguments(13, new int[][] {
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 9, 2, -4, -4, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, -1, -2, -4, 0},
                }),
                arguments(28, new int[][] {
                        {-9, -9, -9, 1, 1, 1},
                        {0, -9, 0, 4, 3, 2},
                        {-9, -9, -9, 1, 2, 3},
                        {0, 0, 8, 6, 6, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, 1, 2, 4, 0},
                })
        );
    }
}