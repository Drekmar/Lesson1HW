package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.*;

class SomeQSortTest {


    @Test
    void givenUnsortedList_whenQSort_thenListIsSorted() {
        // given
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> expected = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9);
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        SomeQSort.qSort(list, comparator);

        // then
        assertEquals(expected, list);
    }

    @Test
    void givenEmptyList_whenQSort_thenListIsUnchanged() {
        // given
        List<Integer> list = Arrays.asList();
        List<Integer> expected = Arrays.asList();
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        SomeQSort.qSort(list, comparator);

        // then
        assertEquals(expected, list);
    }

    @Test
    void givenSingleElementList_whenQSort_thenListIsUnchanged() {
        // given
        List<Integer> list = Arrays.asList(42);
        List<Integer> expected = Arrays.asList(42);
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        SomeQSort.qSort(list, comparator);

        // then
        assertEquals(expected, list);
    }

    @Test
    void givenSortedList_whenQSort_thenListIsUnchanged() {
        // given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        SomeQSort.qSort(list, comparator);

        // then
        assertEquals(expected, list);
    }

    @Test
    void givenReverseSortedList_whenQSort_thenListIsSorted() {
        // given
        List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Comparator<Integer> comparator = Integer::compareTo;

        // when
        SomeQSort.qSort(list, comparator);

        // then
        assertEquals(expected, list);
    }

   


}