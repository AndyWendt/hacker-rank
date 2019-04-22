import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringRepeatTest {
    @ParameterizedTest
    @MethodSource("stringRepeatDataProvider")
    public void it_determines_the_count_of_a_in_a_substring(long expectedCount, long charactersToConsider, String stringToRepeat) {
        long result = StringRepeat.repeatedString(stringToRepeat, charactersToConsider);
        assertSame(expectedCount, result);
    }

    static Stream<Arguments> stringRepeatDataProvider() {
        return Stream.of(
                // expectedCount, characters to consider, string to repeat
                arguments(7, 10, "aba")
        );
    }
}