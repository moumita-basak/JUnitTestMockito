package com.infosys.junittestmockito.newTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;


public class Demotest {
    @Test
    public void testAssertList() {

        LinkedList <Employee> firstList = new LinkedList<>();
        LinkedList <Employee> secondList = new LinkedList<>();
        firstList.addFirst(new Employee(2034));
        secondList.addFirst(new Employee(2034));

        Employee newlist = secondList.getFirst();
        assertTrue(firstList.contains(newlist));
    }

}


