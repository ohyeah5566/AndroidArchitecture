package com.ohyeah5566

import org.junit.Assert
import org.junit.Test

class CICITestCase {

    @Test
    fun firstTest(){
        Assert.assertEquals(123,123)
    }

    @Test
    fun firstWrongTest(){
        Assert.assertEquals(123,122)
    }
}