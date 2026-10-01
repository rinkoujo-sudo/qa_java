package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @Test
    void getKittensReturnsValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion(feline, "Самец");

        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    void constructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(feline, "Неизвестно"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getFoodReturnsFoodFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion(feline, "Самец");

        assertEquals(expected, lion.getFood());
        verify(feline).getFood("Хищник");
    }
}