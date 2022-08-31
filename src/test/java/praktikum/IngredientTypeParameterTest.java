package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.Assert.assertTrue;

public class IngredientTypeParameterTest {
    @ParameterizedTest
    @EnumSource(value = IngredientType.class, names = {"SAUCE", "FILLING"})
    public void ingredientTypeTest(IngredientType type){
        EnumSet<IngredientType> types = EnumSet.allOf(IngredientType.class);
        assertTrue(types.contains(type));
    }
}
