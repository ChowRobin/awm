package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Comment;

import java.util.List;

@Repository
public interface CommentMapper {

    List<Comment> selectByShopId(int ShopId);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}