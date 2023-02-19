package com.example.tests;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class LionTestParametrized {
    private String sex;
    private boolean hasMane;

    public LionTestParametrized(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }
    @Parameterized.Parameters
    public static Object[][] differentSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void checkKnownLionHasManeNotError() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        Assert.assertEquals(lion.doesHaveMane(), hasMane);
    }
}
