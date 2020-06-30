package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;
    private Object Square;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test#" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square();
        //When
        shapeCollector.addFigure(square);
        //Then
        Assert.assertEquals(1, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square();
        //When
        shapeCollector.addFigure(square);
        boolean result = shapeCollector.removeFigure(square);
        //Then
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Square square = new Square();
        //When
        shapeCollector.addFigure(square);
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(square, result);
    }

}