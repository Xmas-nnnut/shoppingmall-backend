package mall.model;

import lombok.Data;

@Data
public class Userorder {
    private Integer id;
    private Integer number;
    private Integer price;
    private String goodsname;
    private String time;
    private Integer uid;

    public Userorder(int number, int price, String goodsname, Integer uid) {
        this.number = number;
        this.price = price;
        this.goodsname = goodsname;
        this.uid = uid;
    }

    public Userorder() {
    }
}