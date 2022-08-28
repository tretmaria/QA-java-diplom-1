package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    Bun bun = new Bun("black bun", 200);

    @Test
    public void getBunNameTest() {
        String expectedResult = "black bun";
        String actualResult = bun.getName();
        assertEquals("Название булочки неверно указано", expectedResult, actualResult);
    }

    @Test
    public void getBunPriceTest() {
        float expectedResult = 200;
        float actualResult = bun.getPrice();
        assertEquals("Цена булочки неверно указана", expectedResult, actualResult, 0);
    }
}
