import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientClassTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;
    private final float delta = 0;
    Ingredient ingredient;

    public IngredientClassTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300},
                {null, "sausage", 300},
                {FILLING, "", 300},
                {FILLING, "sausage", 0},
                {FILLING, "sausage", -300},
                {FILLING, "3415", 300},
                {FILLING, "@#@$", 300},
            };
        }

        @Before
        public void setUp() {
            ingredient = new Ingredient(ingredientType, name, price);
        }
    //Провекра метода getType
        @Test
        public void getTypeTest() {
            Assert.assertEquals(ingredientType, ingredient.getType());
        }
    //Провекра метода getName
        @Test
        public void getNameTest() {
            Assert.assertEquals(name, ingredient.getName());
        }
    //Провекра метода getPrice
        @Test
        public void getPriceTest() {
        Assert.assertEquals(price, ingredient.getPrice(), delta);
    }
}
