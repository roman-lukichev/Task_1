package praktikum.testdata;

import praktikum.IngredientType;

public class BurgerTestData {
    public static final String BUN_NAME = "bun";
    public static final float BUN_PRICE = 75f;

    public static final IngredientType INGREDIENT1_TYPE = IngredientType.SAUCE;
    public static final String INGREDIENT1_NAME = "ingredient1";
    public static final float INGREDIENT1_PRICE = 200f;

    public static final IngredientType INGREDIENT2_TYPE = IngredientType.FILLING;
    public static final String INGREDIENT2_NAME = "ingredient2";
    public static final float INGREDIENT2_PRICE = 300f;

    public static final float TOTAL_PRICE = 2 * BUN_PRICE + INGREDIENT1_PRICE + INGREDIENT2_PRICE;

    public static final String EXPECTED_RECEIPT = new StringBuilder()
            .append(String.format("(==== %s ====)%n", BUN_NAME))
            .append(String.format("= %s %s =%n", INGREDIENT1_TYPE.toString().toLowerCase(), INGREDIENT1_NAME))
            .append(String.format("= %s %s =%n", INGREDIENT2_TYPE.toString().toLowerCase(), INGREDIENT2_NAME))
            .append(String.format("(==== %s ====)%n", BUN_NAME))
            .append(String.format("%nPrice: %f%n", TOTAL_PRICE))
            .toString();

}
