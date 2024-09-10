import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerClassTest {
    private Burger burger;
    private final float delta = 0;

    //стаб Bun
    public Bun mockedBun() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);
        return bunMock;
    }
    //стаб ингредиента Sauce
    public Ingredient mockedSauceIngredient () {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getName()).thenReturn("chili sauce");
        when(ingredientMock.getPrice()).thenReturn(300f);
        return ingredientMock;
    }

    //стаб ингредиента Filling
    public Ingredient mockedFillingIngredient () {
        Ingredient ingredientMock = mock(Ingredient.class);
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock.getName()).thenReturn("dinosaur");
        when(ingredientMock.getPrice()).thenReturn(200f);
        return ingredientMock;
    }

    @Before
    public void setUp() {
        burger = new Burger();
    }

    // Проверка работы метода setBuns
    @Test
    public void setBunMockedTest() {
        Bun expectedBun = mockedBun();
        burger.setBuns(expectedBun);
        Assert.assertEquals(expectedBun, burger.bun);
    }

    // Проверка работы метода addIngredient
    @Test
    public void addIngredientMockedTest() {
        Ingredient expectedIngredient = mockedSauceIngredient();
        burger.addIngredient(expectedIngredient);
        Assert.assertEquals(expectedIngredient, burger.ingredients.get(0));
    }

    // Проверка работы метода removeIngredient
    @Test
    public void removeIngredientMockedTest() {
        Ingredient ingredient = mockedSauceIngredient();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    // Проверка работы метода moveIngredient
    @Test
    public void moveIngredientMockedTest() {
        Ingredient ingredientSauce = mockedSauceIngredient();
        Ingredient ingredientFilling = mockedFillingIngredient();
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredientSauce.name, burger.ingredients.get(1).name);
    }

    // Проверка работы метода getPrice
    @Test
    public void getPriceMockedTest() {
        Bun bun = mockedBun();
        Ingredient ingredient = mockedSauceIngredient();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        Assert.assertEquals(500, actualPrice, delta);
    }

    // Проверка работы метода getReceipt
    @Test
    public void getReceiptMockedTest() {
        Bun bun = mockedBun();
        Ingredient ingredient = mockedSauceIngredient();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format("(==== black bun ====)%n" +
                "= sauce chili sauce =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 500,000000%n");
        Assert.assertEquals(actualReceipt,expectedReceipt);
    }
}

