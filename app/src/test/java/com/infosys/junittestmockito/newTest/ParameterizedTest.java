package com.infosys.junittestmockito.newTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private int a;
    private int b;

    public ParameterizedTest(int a, int b){
        this.a = a;
        this.b = b;
    }

    private static Collection testData(){
        return Arrays.asList(new Object[][]{{1,2}, {5}, {3,3}});
    }

    @Test
    public void test1(){
        Assert.assertTrue(a==b);
    }
}
