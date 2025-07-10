package mall.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty(value = "用户id",required = false,example = "1",hidden = true)
    private String uaccount;
    @ApiModelProperty(value = "用户密码",required = true,example = "123")
    private String upassword;
    @ApiModelProperty(value = "用户名",required = true,example = "ptu")
    private String uname;
    @ApiModelProperty(value = "性别",required = false,example = "男")
    private String usex;
    @ApiModelProperty(value = "地址",required = false,example = "福建省福州市")
    private String uaddress;
    @ApiModelProperty(value = "电话",required = false,example = "114514")
    private String utel;
}