import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunClassTest {
    private final String name;
    private final float price;
    private final float delta = 0;

    public BunClassTest (String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
          {"Флюоресцентная булка", 988},
          {"23", 0},
          {"Флюоресцентная-", -1255},
          {"булка_", 988},
          {"!%№", 988},
          {null, 10},
          {"Fluorescent bread", 3.4e+38f},
        };
    }

    @Test // Проверика метода для поля наименования Bun
    public void getNameBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test // Проверика метода для поля цены Bun с дельтой - 0
    public void getPriceBunParameterizedTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), delta);
    }

}
