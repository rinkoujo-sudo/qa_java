package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 100})
    void felineGetKittensWithCountReturnsSameValue(int count) {
        Feline feline = new Feline();
        assertEquals(count, feline.getKittens(count));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Самец", "Самка"})
    void lionConstructorAcceptsValidSex(String sex) throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(feline, sex);

        boolean expected = "Самец".equals(sex);
        assertEquals(expected, lion.doesHaveMane());
    }

    @ParameterizedTest
    @CsvSource({
            "Хищник, Животные",
            "Хищник, Птицы",
            "Хищник, Рыба"
    })
    void felineEatMeatContainsExpectedFood(String kind, String food) throws Exception {
        Feline feline = new Feline();
        assertEquals(true, feline.getFood(kind).contains(food));
    }
}