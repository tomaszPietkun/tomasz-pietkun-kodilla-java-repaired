package com.kodilla.testing.forum.statistics;

import org.junit.*;
import com.kodilla.testing.forum.statistics.CalculateStatistics;
import com.kodilla.testing.forum.statistics.Statistics;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateStatisticsTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void calculateAdvStatistics1() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(0);
        when(statisticsMock.getCommentsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(4, calculateStatistics.users,0);
        Assert.assertEquals(0, calculateStatistics.posts,0);
        Assert.assertEquals(100, calculateStatistics.comments,0);
        Assert.assertEquals(0.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(25.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.0, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics2() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        when(statisticsMock.getCommentsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);;

        //Then
        Assert.assertEquals(4, calculateStatistics.users,0);
        Assert.assertEquals(1000, calculateStatistics.posts,0);
        Assert.assertEquals(100, calculateStatistics.comments,0);
        Assert.assertEquals(250.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(25.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.1, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics3() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        when(statisticsMock.getCommentsCount()).thenReturn(0);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(4, calculateStatistics.users,0);
        Assert.assertEquals(1000, calculateStatistics.posts, 0);
        Assert.assertEquals(0, calculateStatistics.comments, 0);
        Assert.assertEquals(250.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(0.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.0, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics4() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        when(statisticsMock.getCommentsCount()).thenReturn(200);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(4, calculateStatistics.users,0);
        Assert.assertEquals(1000, calculateStatistics.posts,0);
        Assert.assertEquals(200, calculateStatistics.comments,0);
        Assert.assertEquals(250.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(50.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.2, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics5() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(100);
        when(statisticsMock.getCommentsCount()).thenReturn(500);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(4, calculateStatistics.users,0);
        Assert.assertEquals(100, calculateStatistics.posts,0);
        Assert.assertEquals(500, calculateStatistics.comments,0);
        Assert.assertEquals(25.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(125, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(5, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics6() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();

        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        when(statisticsMock.getCommentsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0, calculateStatistics.users,0);
        Assert.assertEquals(1000, calculateStatistics.posts,0);
        Assert.assertEquals(100, calculateStatistics.comments,0);
        Assert.assertEquals(0.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(0.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.1, calculateStatistics.avrCommentsPerPost,0);
    }
    @Test
    public void calculateAdvStatistics7() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            userNames.add("User nr " + i);
        }
        when(statisticsMock.getUsersNames()).thenReturn((ArrayList<String>) userNames);
        when(statisticsMock.getPostsCount()).thenReturn(1000);
        when(statisticsMock.getCommentsCount()).thenReturn(100);
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100, calculateStatistics.users,0);
        Assert.assertEquals(1000, calculateStatistics.posts,0);
        Assert.assertEquals(100, calculateStatistics.comments,0);
        Assert.assertEquals(10.0, calculateStatistics.avrPostPerUser,0);
        Assert.assertEquals(1.0, calculateStatistics.avrCommentsPerUser,0);
        Assert.assertEquals(0.1, calculateStatistics.avrCommentsPerPost,0);
    }
}