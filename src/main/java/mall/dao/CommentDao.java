package mall.dao;


import mall.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {

    List<Comment> getAllComment();

    List<Comment> getCommentById(Integer gid);
};
