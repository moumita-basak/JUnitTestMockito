package com.infosys.junittestmockito.newTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestMethod {
    @Category(Highpriority.class)
    @Test
    public void testingMethod() {
        String str = "Info";
        assertEquals("Infosys", str.concat("sys"));
    }

    @Category(LowPriority.class)
    @Test
    public void testingMethod1() {
        String str = "INFOSYS";
        assertEquals("INFOSYS", str.toUpperCase());
    }
}
