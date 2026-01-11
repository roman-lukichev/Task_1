package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {

    @ParameterizedTest (name = "[{index}] price = \"{1}\", name = \"{0}\" → success")
    @MethodSource("praktikum.testdata.BunTestData#validBunData")
    void constructorWithValidArgsCreatesObject(String name, float price) {
        Bun bun = new Bun(name, price);
        assertAll("Проверка полей булочки",
                () -> assertEquals(name, bun.getName()),
                () -> assertEquals(price, bun.getPrice(), 0.0001f)
        );
    }

    @ParameterizedTest (name = "[{index}] price = \"{1}\", name = \"{0}\" → exception")
    @MethodSource("praktikum.testdata.BunTestData#invalidBunData")
    void constructorWithInvalidArgsThrowsException(String name, float price) {
        assertThrows(IllegalArgumentException.class, () -> {
            Bun bun = new Bun(name, price);
        });
    }
}