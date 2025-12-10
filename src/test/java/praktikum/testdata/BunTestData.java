package praktikum.testdata;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class BunTestData {

    public static Stream<Arguments> validBunData (){
        return Stream.of(
                Arguments.of("B", 100f),
                Arguments.of("!@#$%^&*", 200.5f),
                Arguments.of("Test Name", 0.0f)
        );
    }

    public static Stream<Arguments> invalidBunData (){
        return Stream.of(
                Arguments.of("Test Bun", -300f),
                Arguments.of("Blue Bun", Float.NaN),
                Arguments.of("Super Bun", Float.POSITIVE_INFINITY),
                Arguments.of("     ", 100f),
                Arguments.of("", 20f),
                Arguments.of(null, 3000f)
        );
    }

}
