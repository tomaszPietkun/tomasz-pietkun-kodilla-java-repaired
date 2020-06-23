package com.kodilla.testing.forum.statistics;

import java.util.ArrayList;
import java.util.List;

public class CalculateStatistics {
    double users;
    double posts;
    double comments;
    double avrPostPerUser;
    double avrCommentsPerUser;
    double avrCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        users = statistics.getUsersNames().size();
        posts = statistics.getPostsCount();
        comments = statistics.getCommentsCount();
        if(users!=0) {
            avrPostPerUser = posts / users;
            avrCommentsPerUser = comments / users;
        }
        else {
            avrPostPerUser = 0;
            avrCommentsPerUser = 0;
        }
        if(posts!=0)
            avrCommentsPerPost = comments / posts;
        else
            avrCommentsPerPost = 0;
    }
}
