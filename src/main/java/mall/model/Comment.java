package mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("评论实体类")
@Data
public class Comment {
    @ApiModelProperty(value = "评论id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "用户id",example = "1")
    private Integer uid;
    @ApiModelProperty(value = "用户名",example = "杨汉")
    private String uname;
    @ApiModelProperty(value = "评论时间",example = "23:33")
    private String time;
    @ApiModelProperty(value = "评论内容",example = "你说的对但是")
    private String comment;
    @ApiModelProperty(value = "商品id",example = "1")
    private Integer gid;
}
