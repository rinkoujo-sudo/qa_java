package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Mock
    Feline feline;

    @Test
    void constructorCreatesMaleLion() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(feline);
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    void getPlaceOfLivingReturnsNewYorkZoo() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void getKittensReturnsZero() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }
}