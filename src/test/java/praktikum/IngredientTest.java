package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @ParameterizedTest(name = "[{index}] type = \"{0}\", price = \"{2}\", name = \"{1}\" → success")
    @MethodSource("praktikum.testdata.IngredientTestData#validIngredientData")
    void constructorWithValidArgsCreatesObject(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertAll("Проверка полей ингредиента",
                () -> assertEquals(type, ingredient.getType()),
                () -> assertEquals(name, ingredient.getName()),
                () -> assertEquals(price, ingredient.getPrice(), 0.0001f)
        );
    }

    @ParameterizedTest (name = "[{index}] type = \"{0}\", price = \"{2}\", name = \"{1}\" → exception")
    @MethodSource("praktikum.testdata.IngredientTestData#invalidIngredientData")
    void constructorWithInvalidArgsThrowsException(IngredientType type, String name, float price) {
        assertThrows(IllegalArgumentException.class, () -> {
            Ingredient ingredient = new Ingredient(type, name, price);
        });
    }
}