package com.tutorial.graphql.service;

import com.tutorial.graphql.records.CommentRecord;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentService {

    Map<String, CommentRecord> comments = new HashMap<>();

    Collection<CommentRecord> createPosts(String content, String postId){
        var newComment = new CommentRecord(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return comments.values();
    }

    CommentRecord commentById(String id){
        return comments.get(id);
    }
}
