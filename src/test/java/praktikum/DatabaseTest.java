package praktikum;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database = new Database();
    @Test
    public void checkIfBunsAreAvailable(){
        List<Bun> actualResult = database.availableBuns();
        assertEquals(3, actualResult.size());
    }
    @Test
    public void checkIfIngredientsAreAvailable(){
        List<Ingredient> actualResult = database.availableIngredients();
        assertEquals(6, actualResult.size());
    }
}
