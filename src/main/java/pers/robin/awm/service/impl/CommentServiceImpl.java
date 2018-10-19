package pers.robin.awm.service.impl;

import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.CommentMapper;
import pers.robin.awm.exception.CheckException;
import pers.robin.awm.model.Comment;
import pers.robin.awm.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    void check(Comment comment) {
        if (comment.getUserId() == null) {
            throw new CheckException("customer id can not be null.");
        } else if (comment.getShopId() == null) {
            throw new CheckException("shop id can not be null.");
        } else if (comment.getContent() == null) {
            throw new CheckException("content can not be null.");
        } else if (comment.getType() == null) {
            throw new CheckException("type can not be null");
        }
    }

    @Override
    public Integer create(Comment comment) {
        check(comment);
        commentMapper.insertSelective(comment);
        return comment.getId();
    }

    @Override
    public Integer update(Comment comment) {
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public Integer delete(int id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer reply(int id, String reply) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setReply(reply);
        return commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public List<Comment> findByShopId(int shopId) {
        return commentMapper.selectByShopId(shopId);
    }
}
