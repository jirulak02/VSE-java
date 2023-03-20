package com.example.document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewTest {
    Interview interview;
    @BeforeEach
    void setUp() {
        interview = new Interview("Karel", "Gott", "dvsdvsbdab", 5);
    }

    @Test
    void getLengthInMinutes() {
        int result = interview.getLengthInMinutes();

        assertEquals(5, result);
    }
}