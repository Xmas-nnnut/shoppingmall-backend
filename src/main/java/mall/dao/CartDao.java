package mall.dao;

import mall.model.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {
    int insertCart(Cart cart);

    Cart getCartByUGid(Integer uid,Integer gid);

    int updateCart(Integer number,Integer price,Integer id);

    List<Cart> getAllCart(Integer uid);

    int deleteOne(Integer id);
    int deleteAll(Integer uid);

    //增加销量
    int updateSales(Integer gid,Integer number);
}