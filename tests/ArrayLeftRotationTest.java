import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayLeftRotationTest {

    @ParameterizedTest
    @MethodSource("rotationsDataProvider")
    public void it_calculates_the_end_state_for_array_rotations(int rotations, int[] input, int[] expected) {
        int[] result = ArrayLeftRotation.rotLeft(input, rotations);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> rotationsDataProvider() {
        return Stream.of(
                // rotations, input int[], expected int[]
                Arguments.arguments(4, new int[] {1, 2, 3, 4, 5}, new int[] {5, 1, 2, 3, 4}),
                Arguments.arguments(9, new int[] {1, 2, 3, 4, 5}, new int[] {5, 1, 2, 3, 4}),
                Arguments.arguments(5, new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}),
                Arguments.arguments(10,
                            new int[] {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51},
                            new int[] {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77}
                        ),
                Arguments.arguments(13,
                        new int[] {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97},
                        new int[] {87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60}
                )
        );
    }
}