package com.d7g.d7gback.contorllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d7g.d7gback.utils.TestDataGenerator;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/TestDataGenerator")
@Slf4j
public class TestDataGeneratorCT {

    @Autowired
    private TestDataGenerator testDataGenerator;

    @PostMapping("/new")
    public ResponseEntity<?> generateTestData(@RequestBody String input) {
        log.info(input);
        log.info(testDataGenerator.detectType(input));
        return ResponseEntity.ok(testDataGenerator.generateTestData(input));
    }
}
