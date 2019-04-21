import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HillsAndValleysTest {

    @ParameterizedTest
    @MethodSource("hillsAndValleysDataProvider")
    void it_finds_valleys_for_a_given_string(int expectedValleys, String s) {
        int result = HillsAndValleys.countingValleys(s.length(), s);
        assertSame(expectedValleys, result);
    }

    static Stream<Arguments> hillsAndValleysDataProvider() {
        return Stream.of(
                // expected, string
                arguments(1, "UDDDUDUU"),
                arguments(2, "DDUUDDUDUUUD")
        );
    }

}