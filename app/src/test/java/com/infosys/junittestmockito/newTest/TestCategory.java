package com.infosys.junittestmockito.newTest;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)

@Category(Highpriority.class)

@Suite.SuiteClasses({ TestMethod.class })
    public class TestCategory {


}
