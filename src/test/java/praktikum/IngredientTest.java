package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;


public class IngredientTest {
    int delta = 0;
    Ingredient ingredient = new Ingredient(SAUCE, "hot sauce", 100);
    @Test
    public void getIngredientTypeTest(){
        IngredientType expectedResult = SAUCE;
        assertEquals("Вид ингредиента неправильный", expectedResult, ingredient.getType());
    }
    @Test
    public void getIngredientPriceTest() {
        float expectedResult = 100;
        float actualResult = ingredient.getPrice();
        assertEquals("Цена ингредиента неправильная", expectedResult, actualResult, delta);
    }

    @Test
    public void getIngredientNameTest() {
        String expectedResult = "hot sauce";
        String actualResult = ingredient.getName();
        assertEquals("Название ингредиента неправильное", expectedResult, actualResult);
    }
}
