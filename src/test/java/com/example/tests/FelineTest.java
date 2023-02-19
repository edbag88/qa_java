package com.example.tests;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;

    @Test
    public void eatMeatReturnPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы","Рыба"));
        List<String> expectedFood = List.of("Животные","Птицы","Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
    @Test
    public void getFamilyReturnsFelineRu() {
        Feline feline = new Feline();
        String expectedFamilyRu = "Кошачьи";

        assertEquals(expectedFamilyRu, feline.getFamily());
    }
    @Test
    public void getKittensReturnsRelevantNumber() {
        Feline feline = new Feline();
        int expectedKittensCount = 1;

        assertEquals(expectedKittensCount, feline.getKittens());
    }
}

