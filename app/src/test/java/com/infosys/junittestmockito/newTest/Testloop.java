package com.infosys.junittestmockito.newTest;

import org.junit.Assert;
import org.junit.Test;

public class Testloop {
    Loopdemo tc=new Loopdemo();
    char value;
    @Test
    public void testdispaly(){
        value=tc.display(70);
        Assert.assertSame(value, 'B');
    }}

