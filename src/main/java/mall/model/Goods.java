package mall.model;

import lombok.Data;

@Data
public class Goods {
    private Integer gid;
    private Integer gprice;
    private String gname;
    private String gdetails;
    private  Integer types;
    private String gpicture;
}