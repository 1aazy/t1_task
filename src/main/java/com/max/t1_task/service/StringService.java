package com.max.t1_task.service;

import com.max.t1_task.exception.EmptyStringExcption;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringService {

    private static Map<Character, Integer> frequencyMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    public List<Map.Entry<Character, Integer>> getCharacterFrequency(String sourceStr) {

        if (sourceStr.isBlank() || sourceStr.isEmpty()) {
            throw new EmptyStringExcption("String couldn't be empty");
        }

        Map<Character, Integer> map = frequencyMap(sourceStr);

        List<Map.Entry<Character, Integer>> entities = new ArrayList<>(map.entrySet());

        entities.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        return entities;
    }
}
