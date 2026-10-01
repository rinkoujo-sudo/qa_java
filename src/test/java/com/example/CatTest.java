package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Predator predator;

    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(null);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(null);
        cat.predator = predator;

        assertEquals(expected, cat.getFood());
        verify(predator).eatMeat();
    }
}