package mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("购物车实体类")
@Data
public class Cart {
    @ApiModelProperty(value = "购物车id",required = false,example = "1")
    private Integer id;
    @ApiModelProperty(value = "商品名称",required = false,example = "苹果")
    private String goodsname;
    @ApiModelProperty(value = "数量",required = true,example = "2")
    private Integer number;
    @ApiModelProperty(value = "价格",required = false,example = "100")
    private Integer price;
    @ApiModelProperty(value = "商品id",required = true,example = "1")
    private Integer goodid;
    @ApiModelProperty(value = "用户id",required = true,example = "1")
    private Integer uid;
    @ApiModelProperty(value = "商品图片",example = "http://127.0.0.1:8080/img/1.jpg")
    private String gpicture;
}