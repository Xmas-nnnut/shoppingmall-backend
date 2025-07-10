package mall.service;


import com.github.pagehelper.PageInfo;
import mall.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart insertCart(Cart cart);
    PageInfo<Cart> getAllCart(Integer uid, Integer pageNum, Integer pageSize);
    Cart modifyNumber(Integer uid,Integer gid,Integer type);
    int deleteOne(Integer id);
    int deleteAll(Integer uid);
    int payCart(Integer uid);
}