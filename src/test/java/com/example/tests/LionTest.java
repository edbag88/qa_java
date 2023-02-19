package com.example.tests;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void checkGetKittensMocked() throws Exception{
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }
    @Test
    public void checkGetFoodMocked() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
    @Test
    public void getLionHasNoKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(0, lion.getKittens());
    }
    @Test
    public void getLionEatsMeatTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedEatMeat, feline.getFood("Хищник"));
    }
    @Test
    public void checkUnknownSexLionHasManeError() {
        try {
            new Lion("Новый вид", feline);
        } catch (Exception thrown) {
            String expected = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertEquals(expected, thrown.getMessage());
        }
    }
}
