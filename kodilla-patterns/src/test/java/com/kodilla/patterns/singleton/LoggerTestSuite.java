package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void openSettingsFile() {
        Logger.getInstance().log("User logged out");
    }

    @AfterClass
    public static void closeSettingsFile() {

    }

    @Test
    public void testGetLastLog() {
        //Given
        //When
        String lastLogName = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("User logged out", lastLogName);
    }

}
