import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SockMerchantTest {

    @ParameterizedTest
    @MethodSource("sockPairsDataProvider")
    void it_finds_the_pairs_for_socks(int expectedPairs, int[] socks) {
        int result = SockMerchant.calcPairs(socks.length, socks);
        assertSame(expectedPairs, result);
    }

    static Stream<Arguments> sockPairsDataProvider() {
        return Stream.of(
                // expected, int[]
                arguments(2, new int[] {1,2,1,2,1,3,2})
        );
    }
}