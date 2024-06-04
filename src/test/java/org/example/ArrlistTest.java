package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;


class ArrlistTest {

    private Arrlist<Integer> list;

    @BeforeEach
    void setUp() {
        list = new Arrlist<>();
    }

    @Test
    void testConstructorWithInitialCapacity() {
        // given
        int initialCapacity = 10;

        // when
        Arrlist<Integer> customList = new Arrlist<>(initialCapacity);

        // then
        assertEquals(initialCapacity, customList.size());
    }

    @Test
    void testConstructorWithArray() {
        // given
        Integer[] initialArray = {1, 2, 3};

        // when
        Arrlist<Integer> customList = new Arrlist<>(initialArray);

        // then
        assertEquals(initialArray.length, customList.size());
        assertEquals(Arrays.asList(initialArray), customList);
    }

    @Test
    void testAddElement() {
        // given
        Integer element = 5;

        // when
        list.add(element);

        // then
        assertEquals(1, list.size());
        assertEquals(element, list.get(0));
    }

    @Test
    void testAddElementAtIndex() {
        // given
        Integer element = 5;
        list.add(1); // Adding an initial element

        // when
        list.add(0, element);

        // then
        assertEquals(2, list.size());
        assertEquals(element, list.get(0));
    }

    @Test
    void testSetElement() {
        // given
        Integer initialElement = 1;
        Integer newElement = 5;
        list.add(initialElement);

        // when
        Integer oldElement = list.set(0, newElement);

        // then
        assertEquals(initialElement, oldElement);
        assertEquals(newElement, list.get(0));
    }

    @Test
    void testAddAllElements() {
        // given
        Integer[] elements = {1, 2, 3};

        // when
        list.addAll(elements);

        // then
        assertEquals(elements.length, list.size());
        assertEquals(Arrays.asList(elements), list);
    }




}