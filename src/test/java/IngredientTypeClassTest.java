import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeClassTest {

    @Test
    public void sauceNotNullTest() {
        Assert.assertNotNull("Sauce is null", IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingNotNullTest() {
        assertNotNull("Filling is null", IngredientType.valueOf("FILLING"));
    }
}
