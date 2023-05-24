package mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mall.dao.CommentDao;
import mall.model.Comment;
import mall.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    CommentDao commentDao;

    @Override
    public PageInfo<Comment> getAllComment(Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentDao.getAllComment();

        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    @Override
    public PageInfo<Comment> getCommentById(Integer gid, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList = commentDao.getCommentById(gid);

        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

}
