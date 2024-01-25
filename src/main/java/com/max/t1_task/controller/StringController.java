package com.max.t1_task.controller;

import com.max.t1_task.exception.EmptyStringExcption;
import com.max.t1_task.exception.EmptyStringResponse;
import com.max.t1_task.service.StringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class StringController {

    private final StringService stringService;

    public StringController(StringService stringService) {
        this.stringService = stringService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Map.Entry<Character, Integer>> serv(@RequestParam String str) {
        str = str.replaceAll("\\s", "");
        return stringService.getCharacterFrequency(str);
    }

    @ExceptionHandler
    public ResponseEntity<EmptyStringResponse> handleNotFoundExc(EmptyStringExcption e) {
        EmptyStringResponse response = new EmptyStringResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
