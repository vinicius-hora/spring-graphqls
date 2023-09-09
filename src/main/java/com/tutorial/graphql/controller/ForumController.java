package com.tutorial.graphql.controller;

import com.tutorial.graphql.records.CommentRecord;
import com.tutorial.graphql.records.PostRecord;
import com.tutorial.graphql.service.CommentService;
import com.tutorial.graphql.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class ForumController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
//    @SchemaMapping(typeName = "Query", value = "postById")
    @QueryMapping
    public PostRecord postById(@Argument String id){
        System.out.println("PostById");
        return postService.postById(id);
    }
    @MutationMapping
    public Collection<PostRecord> createPost(@Argument String content){
        return postService.createPosts(content);
    }
    @MutationMapping
    public Collection<CommentRecord> createComment(@Argument String content, @Argument String postId){
        return commentService.createPosts(content, postId);
    }

    @SchemaMapping
    public Collection<CommentRecord> comments(PostRecord post){
        System.out.println("Comments");
        return commentService.findByPost(post.id());
    }


}
