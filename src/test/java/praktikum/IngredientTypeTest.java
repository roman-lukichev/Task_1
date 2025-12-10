package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//тестирование на мой взгляд не имеет смысла (тут нечего тестировать), но это требуется в задании
//поэтому вот
class IngredientTypeTest {

    @Test
    void hasSauceType() {
        // Проверяем, что есть константа SAUCE и ее имя соответствует ожидаемому
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    void hasFillingType() {
        // Проверяем, что есть константа FILLING и ее имя соответствует ожидаемому
        assertEquals("FILLING", IngredientType.FILLING.name());
    }

}