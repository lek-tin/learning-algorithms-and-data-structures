https://chat.openai.com/c/c981ae95-2a41-48a3-8d84-26ecc8e345ec


/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.time.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


# Implement an in-memory social media platform

# 1. createPost(userId, postId)
# 2. follow(followerId, followedId)
# 3. unfollow(followerId, followedId)
# 4. getNewsFeed(userId)
#     1. Return a list of 10 most recent post ids in the user’s news feed
#     2. The news feed must contain posts created by the user themselves or the users they follow
#     3. News feed must be in descending chronological order

# For example:
# createPost(userId1, postId1)
# createPost(userId2, postId2)
# follow(userId1, userId2)
# getNewsFeed(userId1) // postId2, postId1
# getNewsFeed(userId2) // postId2

# unfollow(userId1, userId2)
# getNewsFeed(userId1) // postId1
 
 */

class Post {
  public String title;
  public String content;
  public String createdBy; // userId
  public String id;
  public long timestamp;

  public Post(String postId) {
    title = "title";
    content = "content";
    timestamp = Instant.now().toEpochMilli();
    this.id = postId;
  }
}

class User {
  public String userId;
  public List<Post> posts; // only post content as strings
  public Set<String> following; // userIds

  public User(String userId) {
    this.userId = userId;
    this.posts = new ArrayList<>();
    this.following = new HashSet<>();
  }

  public void createPost(String postId) {
    posts.add(new Post(postId));
  }
  public void follow(String followingId) {
    // add followerId as a follower
    following.add(followingId);
  }
  public void unfollow(String followingId) {
    // removes followerId as a follower
    following.remove(followingId);
  }
}

class SocialMedia {
  public Map<String, User> users; // <UserId, User>
  public Map<String, String> posts; // <postId, userId>

  public SocialMedia() {
    this.users = new HashMap<>();
    users.put("001", new User("001"));
    users.put("002", new User("002"));
    users.put("003", new User("003"));
    this.posts = new HashMap<>();
  }

  public void createUser(String userId) {
    // todo
  }

  public void createPost(String userId, String postId) {
    if (users.containsKey(userId)) {
      users.get(userId).createPost(postId);
      posts.put(postId, userId);
    } else {
      System.out.println("User " + userId + " does not exist");
    }
  }

  public void follow(String followerId, String followedId) {
    if (users.containsKey(followerId) && users.containsKey(followerId)) {
      users.get(followerId).follow(followedId);
    } else {
      System.out.println("followerId " + followerId + " does not exist");
    }
  }

  public void unfollow(String followerId, String unfollowedId) {
    if (users.containsKey(followerId) && users.containsKey(followerId)) {
      users.get(followerId).unfollow(unfollowedId);
    } else {
      System.out.println("followerId " + followerId + " does not exist");
    }
  }

  public List<String> getNewsFeed(String userId) {
    List<String> newsFeed = new ArrayList<>(); // list of postIds
    PriorityQueue<Map.Entry<String, Long>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));

    if (users.containsKey(userId)) {
      Set<String> following = users.get(userId).following;
      for (String followingId: following) {
        User followedUser = users.get(followingId);
        for (Post post: followedUser.posts) {
          maxHeap.offer(Map.entry(post.id, post.timestamp));
        }
      }
      // push each post from each following user into the maxHeap
    } else {
      // user doesn't exist
    }

    // add own posts
    for (Post post: users.get(userId).posts) {
      maxHeap.offer(Map.entry(post.id, post.timestamp));
    }

    // pop off the top 10 most recent posts and add them to newsFeed
    int i = 0;
    while (!maxHeap.isEmpty() && i < 10) {
      newsFeed.add(maxHeap.poll().getKey());
    }

    return newsFeed;
  }
}

class Solution {
  public static void main(String[] args) {
    SocialMedia socialMedia = new SocialMedia();

    socialMedia.follow("001", "002"); // 001 follows 002
    socialMedia.follow("001", "003"); // 001 follows 003
    socialMedia.follow("002", "003"); // 001 follows 003


// createPost(userId1, postId1)
// createPost(userId2, postId2)
// follow(userId1, userId2)
  }
}
