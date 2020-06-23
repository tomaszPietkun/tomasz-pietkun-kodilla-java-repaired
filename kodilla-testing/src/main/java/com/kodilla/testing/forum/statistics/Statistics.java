package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> getUsersNames(); // list of users names
    int getPostsCount();          // total quantity of forum posts
    int getCommentsCount();       // total quantity of forum comments
}