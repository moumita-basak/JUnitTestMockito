package com.infosys.junittestmockito.newTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TestClassB.class, TestClassA.class})
public class SuiteTest {
}
