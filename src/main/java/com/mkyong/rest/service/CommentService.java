package com.mkyong.rest.service;

import com.mkyong.rest.database.DatabaseClass;
import com.mkyong.rest.model.Comment;
import com.mkyong.rest.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by UI61LN on 7/17/2017.
 */
public class CommentService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public CommentService() {
        Map<Long, Comment> comments = messages.get(1L).getComments();
        comments.put(1L, new Comment(1, "Test comment!", "Alex"));
        comments.put(2L, new Comment(2, "Test comment number 2!", "Vlad"));
    }

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment deleteComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
