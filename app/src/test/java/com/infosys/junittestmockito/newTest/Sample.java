package com.infosys.junittestmockito.newTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class Sample {

   @Test
    public void test1(){
        A a = new A();
        A b = a;
        Assert.assertNotSame(a.getClass(), b.getClass());

    }
}
