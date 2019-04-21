import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CloudJumpingTest {

    @ParameterizedTest
    @MethodSource("cloudJumpingDataProvider")
    public void it_finds_the_minimum_moves_between_clouds(int expectedMoves, int[] clouds) {
        int result = CloudJumping.jumpingOnClouds(clouds);
        assertSame(expectedMoves, result);
    }

    public static Stream<Arguments> cloudJumpingDataProvider() {
        return Stream.of(
                // expected, clouds
                arguments(3, new int[] {0, 0, 0, 0, 1, 0}),
                arguments(4, new int[] {0, 0, 1, 0, 0, 1, 0})
        );
    }
}