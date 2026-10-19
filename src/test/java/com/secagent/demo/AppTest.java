package com.secagent.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    @Test
    void escapesHtml() {
        assertEquals("&lt;example&gt;", new App().escape("<example>"));
    }
}
