package com.tutorial.graphql.service;

import com.tutorial.graphql.records.CommentRecord;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {

    Map<String, CommentRecord> comments = new HashMap<>();

    public Collection<CommentRecord> createPosts(String content, String postId){
        var newComment = new CommentRecord(UUID.randomUUID().toString(), content, postId);
        comments.put(newComment.id(), newComment);
        return comments.values();
    }

    public CommentRecord commentById(String id){
        return comments.get(id);
    }

    public List<CommentRecord> findByPost(String id) {
        return comments.values().stream().filter(commentRecord ->
                commentRecord.postId()
                        .equals(id)).toList();
    }
}
