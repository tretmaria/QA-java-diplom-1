package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void shouldChooseBunTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("black bun");
        assertThat(burger.getReceipt(), containsString("black bun"));
        System.out.println(burger.getReceipt());
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        String expectedIngredient = "sour cream";
        assertEquals(expectedIngredient, burger.ingredients.get(0).name);
        System.out.println(burger.ingredients.get(0).name);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 300));
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
        System.out.println(burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        burger.moveIngredient(1, 0);
        String expectedIngredient = "cutlet";
        assertEquals(2, burger.ingredients.size());
        assertNotEquals(expectedIngredient, burger.ingredients.get(1).name);
        System.out.println(burger.ingredients.get(1).name);
    }

    @Test
    public void getBurgerPriceTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0);
        System.out.println(expectedPrice);
    }

    @Test
    public void getBurgerReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        String expectedBurger = "(==== black bun ====)\n" + "= sauce sour cream =\n" + "(==== black bun ====)\n" + "Price: 400.000000\n";
        System.out.println(expectedBurger);
        System.out.println(burger.getReceipt());
        assertThat(burger.getReceipt(), containsString("sauce sour cream"));
        assertThat(burger.getReceipt(), anyOf(endsWith("Price: 400.000000"), startsWith("(==== black bun ====)")));
    }
}
