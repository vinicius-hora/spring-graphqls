package com.tutorial.graphql.service;

import com.tutorial.graphql.records.PostRecord;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PostService {
    Map<String, PostRecord> posts = new HashMap<>();

    Collection<PostRecord> createPosts(String content){
        var newPost = new PostRecord(UUID.randomUUID().toString(), content);
        posts.put(newPost.id(), newPost);
        return posts.values();
    }

    PostRecord postById(String id){
        return posts.get(id);
    }
}
