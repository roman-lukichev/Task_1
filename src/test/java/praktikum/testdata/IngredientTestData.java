package praktikum.testdata;

import org.junit.jupiter.params.provider.Arguments;
import praktikum.IngredientType;

import java.util.stream.Stream;

public class IngredientTestData {

    public static Stream<Arguments> validIngredientData (){
        return Stream.of(
                Arguments.of(IngredientType.SAUCE, "P", 100f),
                Arguments.of(IngredientType.FILLING, "!@#$%^&*", 200.5f),
                Arguments.of(IngredientType.FILLING, "Super Sausage", 0.0f)
        );
    }

    public static Stream<Arguments> invalidIngredientData (){
        return Stream.of(
                Arguments.of(IngredientType.FILLING, "Sausage", -300f),
                Arguments.of(IngredientType.FILLING, "Cutlet", Float.NaN),
                Arguments.of(IngredientType.SAUCE, "Ketchup", Float.POSITIVE_INFINITY),
                Arguments.of(IngredientType.SAUCE, "     ", 100f),
                Arguments.of(IngredientType.SAUCE, "", 20f),
                Arguments.of(IngredientType.SAUCE, null, 3000f),
                Arguments.of(null, "Cucumber", 100f)
        );
    }

}
