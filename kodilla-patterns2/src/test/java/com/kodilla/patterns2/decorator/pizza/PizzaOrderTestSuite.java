package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce", description);
    }

    @Test
    public void testHamPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamPizzaDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    public void testHamPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamPizzaDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce + ham", description);
    }

    @Test
    public void testPepperoniAndJalapenoPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PepperoniPizzaDecorator(theOrder);
        theOrder = new JalapenoPizzaDecorator(theOrder);
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(22), cost);
    }

    @Test
    public void testPepperoniAndJalapenoPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PepperoniPizzaDecorator(theOrder);
        theOrder = new JalapenoPizzaDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce + pepperoni + jalapeno peppers", description);
    }

    @Test
    public void testHamAndPineapplePizzaOrderWithExtraCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheesePizzaDecorator(theOrder);
        theOrder = new HamPizzaDecorator(theOrder);
        theOrder = new PineapplePizzaDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //When
        BigDecimal cost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), cost);
    }

    @Test
    public void testHamAndPineapplePizzaOrderWithExtraCheeseGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheesePizzaDecorator(theOrder);
        theOrder = new HamPizzaDecorator(theOrder);
        theOrder = new PineapplePizzaDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce + extra cheese + ham + pineapple", description);
    }
}
