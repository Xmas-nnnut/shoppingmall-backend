package mall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("订单实体类")
@Data
public class Userorder {
    @ApiModelProperty(value = "订单id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "购买数量",example = "2")
    private Integer number;
    @ApiModelProperty(value = "订单价格",example = "2")
    private Integer price;
    @ApiModelProperty(value = "商品名称",example = "苹果")
    private String goodsname;
    @ApiModelProperty(value = "下单时间",example = "2023-05-07")
    private String time;
    @ApiModelProperty(value = "用户id",example = "1")
    private Integer uid;
    @ApiModelProperty(value = "商品id",example = "1")
    private Integer gid;
    @ApiModelProperty(value = "商品图片",example = "http://127.0.0.1:8080/img/1.jpg")
    private String gpicture;

    public Userorder(int number, int price, String goodsname, Integer uid, Integer gid, String gpicture) {
        this.number = number;
        this.price = price;
        this.goodsname = goodsname;
        this.uid = uid;
        this.gid = gid;
        this.gpicture = gpicture;
    }

    public Userorder() {
    }
}