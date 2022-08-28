package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DatabaseTest {
    Database database = new Database();
    @Test
    public void checkIfBunsAreAvailable(){
        List<Bun> actualResult = database.availableBuns();
        assertNotNull("Булочек нет", actualResult);
    }
    @Test
    public void checkIfIngredientsAreAvailable(){
        List<Ingredient> actualResult = database.availableIngredients();
        assertNotNull("Ингредиентов нет", actualResult);
    }
}
