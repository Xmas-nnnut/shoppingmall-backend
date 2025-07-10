package mall.service;

import com.github.pagehelper.PageInfo;
import mall.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    PageInfo<Comment> getAllComment(Integer pageNum, Integer pageSize);

    PageInfo<Comment> getCommentById(Integer gid, Integer pageNum, Integer pageSize);
}
