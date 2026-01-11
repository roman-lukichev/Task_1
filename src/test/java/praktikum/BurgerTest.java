package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static praktikum.testdata.BurgerTestData.*;

@ExtendWith(MockitoExtension.class)
class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;

    @Mock
    Ingredient ingredient2;

    Burger burger;

    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @Test
    void setBunsValidBunUpdatesBunField() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    void addIngredientAnyIngredientAddsToList() {
        burger.addIngredient(ingredient1);
        assertTrue(burger.ingredients.contains(ingredient1));
    }

    @Test
    void removeIngredientValidIndexRemovesFromList() {
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient1));
    }

    @Test
    void moveIngredientValidIndicesChangesOrder() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertAll("Проверка порядка ингредиентов",
                ()-> assertEquals(ingredient1, burger.ingredients.get(1)),
                ()-> assertEquals(ingredient2, burger.ingredients.get(0))
        );
    }

    @Test
    void getPriceBurgerWithBunAndIngredientsReturnsTotalSum() {
        setupMocksPrice();
        assembleBurger();
        assertEquals(TOTAL_PRICE, burger.getPrice(), 0.0001f);
    }

    @Test
    void getReceiptBurgerWithBunAndIngredientsReturnsFormattedString() {
        setupMocksPrice();
        setupMocksNameAndType();
        assembleBurger();
        assertEquals(EXPECTED_RECEIPT, burger.getReceipt());
    }

    private void setupMocksPrice(){
        when(bun.getPrice()).thenReturn(BUN_PRICE);
        when(ingredient1.getPrice()).thenReturn(INGREDIENT1_PRICE);
        when(ingredient2.getPrice()).thenReturn(INGREDIENT2_PRICE);
    }

    private void setupMocksNameAndType(){
        when(bun.getName()).thenReturn(BUN_NAME);

        when(ingredient1.getName()).thenReturn(INGREDIENT1_NAME);
        when(ingredient1.getType()).thenReturn(INGREDIENT1_TYPE);

        when(ingredient2.getName()).thenReturn(INGREDIENT2_NAME);
        when(ingredient2.getType()).thenReturn(INGREDIENT2_TYPE);
    }

    private void assembleBurger(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }
}