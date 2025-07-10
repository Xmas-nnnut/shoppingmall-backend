package mall.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("商品实体类")
@Data
public class Goods {
    @ApiModelProperty(value = "商品id",example = "1")
    private Integer gid;
    @ApiModelProperty(value = "商品价格",example = "100")
    private Integer gprice;
    @ApiModelProperty(value = "商品名称",example = "苹果")
    private String gname;
    @ApiModelProperty(value = "商品描述",example = "红富士苹果")
    private String gdetails;
    @ApiModelProperty(value = "商品类型",example = "0")
    private  Integer types;
    @ApiModelProperty(value = "商品图片",example = "http://127.0.0.1:8080/img/1.jpg")
    private String gpicture;
    @ApiModelProperty(value = "商品详情",example = "0")
    private Integer sales;
}
