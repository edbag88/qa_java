package com.example.tests;
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class CatTest {
    Feline feline = new Feline();

    @Test
    public void checkCorrectCatGetSound() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void checkPredatorFood() throws Exception {
        Cat cat = new Cat(feline);
        List expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expected, cat.getFood());
    }
}
