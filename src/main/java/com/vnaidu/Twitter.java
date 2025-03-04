package com.vnaidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter extends Base {
    private static int timestamp = 0;

    private static class Tweet {
        int id, time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    private static class User {
        int id;
        Set<Integer> following;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            following = new HashSet<>();
            following.add(id); // Follow itself
        }

        public void postTweet(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }

        public void follow(int followeeId) {
            following.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (followeeId != id) {
                following.remove(followeeId);
            }
        }
    }

    private final Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (!userMap.containsKey(userId)) return feed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int followeeId : userMap.get(userId).following) {
            Tweet tweet = userMap.get(followeeId).tweetHead;
            if (tweet != null) {
                pq.offer(tweet);
            }
        }

        while (!pq.isEmpty() && feed.size() < 10) {
            Tweet tweet = pq.poll();
            feed.add(tweet.id);
            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}

