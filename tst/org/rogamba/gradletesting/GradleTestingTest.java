package org.rogamba.gradletesting;

import org.junit.Assert;
import org.junit.Test;

public class GradleTestingTest {
    @Test
    public void testSum(){
        Integer a = 1;
        Integer b = 2;
        Integer actual = GradleTesting.sumNumbers(a,b);
        Integer expected = 3;
        Assert.assertEquals(actual,expected);
    }
}