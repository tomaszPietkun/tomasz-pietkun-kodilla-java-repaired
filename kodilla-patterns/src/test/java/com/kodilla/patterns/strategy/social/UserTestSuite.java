package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.Customer;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User marcin = new ZGeneration("Marcin Majkut");
        User jan = new Millenials("Jan Kowalski");
        User jolanta = new YGeneration("Jolanta Kopaczynska");

        //When
        String marcinShouldPublish = marcin.sharePost();
        System.out.println("Marcin should publish post on: " + marcinShouldPublish);
        String janShouldPublish = jan.sharePost();
        System.out.println("Jan should publish post on: " + janShouldPublish);
        String jolantaShouldPublish = jolanta.sharePost();
        System.out.println("Jolanta should publish post on: " + jolantaShouldPublish);

        //Then
        Assert.assertEquals("Snapchat", marcinShouldPublish);
        Assert.assertEquals("Facebook", janShouldPublish);
        Assert.assertEquals("Twitter", jolantaShouldPublish);

    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User marcin = new ZGeneration("Marcin Majkut");

        //When
        String marcinShouldPublish = marcin.sharePost();
        System.out.println("Marcin should publish post on: " + marcinShouldPublish);
        marcin.setSocialPublisher(new FacebookPublisher());
        marcinShouldPublish = marcin.sharePost();
        System.out.println("Marcin should now publish post on: " + marcinShouldPublish);

        //Then
        Assert.assertEquals("Facebook", marcinShouldPublish);

    }
}
