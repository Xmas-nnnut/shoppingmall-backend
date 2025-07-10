package mall.controller;


import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mall.model.Comment;
import mall.model.Goods;
import mall.service.CommentService;
import mall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "5-评论接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @ApiOperation("分页获取商品首页列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "当前页数量",dataTypeClass = Integer.class,required = true,defaultValue = "4"),
    })
    @GetMapping("/all")
    public Result getAllcomment (@RequestParam(name = "pageNum") Integer pageNum,
                                 @RequestParam(name = "pageSize") Integer pageSize)
    {
        PageInfo<Comment> pageInfo = commentService.getAllComment(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据商品id(gid)，分页获取商品评论列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "gid",value = "商品id",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "当前页数量",dataTypeClass = Integer.class,required = true,defaultValue = "4"),
    })
    @GetMapping("/{gid}")
    public Result getCommentById(@PathVariable(name = "gid") Integer gid,
                                  @RequestParam(name = "pageNum") Integer pageNum,
                                  @RequestParam(name = "pageSize") Integer pageSize)
    {
        PageInfo<Comment> pageInfo = commentService.getCommentById(gid,pageNum,pageSize);
        return Result.success(pageInfo);
    }

}
