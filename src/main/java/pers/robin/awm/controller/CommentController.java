package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Comment;
import pers.robin.awm.service.CommentService;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/shop/{shop_id}/getcomments")
    public ResultBean<List<Comment>> getCommentByShopId(@PathVariable("shop_id") int shopId) {
        return new ResultBean<>(commentService.findByShopId(shopId));
    }

    @PostMapping("/customer/addcomment")
    public ResultBean<Integer> addComment(@RequestBody Comment comment) {
        return new ResultBean<>(commentService.create(comment));
    }

    @PostMapping("/shop/replycomment/{comment_id}")
    public ResultBean<Integer> replyComment(@PathVariable("comment_id") int commentId,
                                            @RequestBody String reply) {
        return new ResultBean<>(commentService.reply(commentId, reply));
    }

    @PostMapping("/comment/update/{comment_id}")
    public ResultBean<Integer> update(@PathVariable("comment_id") int commentId,
                                      @RequestBody Comment comment) {
        comment.setId(commentId);
        return new ResultBean<>(commentService.update(comment));
    }

    @GetMapping("/comment/delete/{comment_id}")
    public ResultBean<Integer> delete(@PathVariable("comment_id") int commentId) {
        return new ResultBean<>(commentService.delete(commentId));
    }

}
