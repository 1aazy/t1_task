package com.max.t1_task.service;

import com.max.t1_task.exception.EmptyStringExcption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {

    StringService stringService;

    @BeforeEach
    public void init() {
        stringService = new StringService();
    }

    @Test
    void getCharacterFrequency_InputAaaaabccccString_CorrectFrequencies() {
        String input = "aaaaabccccc";

        List<Map.Entry<Character, Integer>> excepted = new ArrayList<>();
        List<Map.Entry<Character, Integer>> actual = stringService.getCharacterFrequency(input);

        excepted.add(new AbstractMap.SimpleEntry<>('a', 5));
        excepted.add(new AbstractMap.SimpleEntry<>('c', 5));
        excepted.add(new AbstractMap.SimpleEntry<>('b', 1));

        assertEquals(excepted, actual);
    }

    @Test
    void getCharacterFrequency_InputSetOfSigns_CorrectFrequencies() {
        String input = "@@#$%^&*()_-+==!?//...,,,```~~~";

        List<Map.Entry<Character, Integer>> excepted = new ArrayList<>();
        List<Map.Entry<Character, Integer>> actual = stringService.getCharacterFrequency(input);

        excepted.add(new AbstractMap.SimpleEntry<>('`', 3));
        excepted.add(new AbstractMap.SimpleEntry<>(',', 3));
        excepted.add(new AbstractMap.SimpleEntry<>('.', 3));
        excepted.add(new AbstractMap.SimpleEntry<>('~', 3));
        excepted.add(new AbstractMap.SimpleEntry<>('@', 2));
        excepted.add(new AbstractMap.SimpleEntry<>('/', 2));
        excepted.add(new AbstractMap.SimpleEntry<>('=', 2));
        excepted.add(new AbstractMap.SimpleEntry<>('!', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('#', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('$', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('%', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('&', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('(', 1));
        excepted.add(new AbstractMap.SimpleEntry<>(')', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('*', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('+', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('-', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('^', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('_', 1));
        excepted.add(new AbstractMap.SimpleEntry<>('?', 1));

        assertEquals(excepted, actual);
    }

    @Test
    void getCharacterFrequency_InputBlankString_EmptyStringException() {
        assertThrows(EmptyStringExcption.class, () -> stringService.getCharacterFrequency(""));
    }
}