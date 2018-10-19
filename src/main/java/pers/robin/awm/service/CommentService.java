package pers.robin.awm.service;

import pers.robin.awm.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findByShopId(int shopId);

    Integer create(Comment comment);

    Integer update(Comment comment);

    Integer delete(int id);

    Integer reply(int id, String reply);
}
