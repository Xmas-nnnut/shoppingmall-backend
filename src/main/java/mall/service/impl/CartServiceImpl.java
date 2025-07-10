package mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mall.dao.CartDao;
import mall.dao.GoodsDao;
import mall.dao.OrderDao;
import mall.model.Cart;
import mall.model.Goods;
import mall.model.Userorder;
import mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired(required = false)
    CartDao cartDao;
    @Autowired(required = false)
    GoodsDao goodsDao;
    @Autowired(required = false)
    OrderDao orderDao;
    @Value("${image.prefix-url}")
    String imgUrl;

    @Override
    public Cart insertCart(Cart cart) {
        Cart cartJdbc = cartDao.getCartByUGid(cart.getUid(),cart.getGoodid());
        Goods goods = goodsDao.getGoodById(cart.getGoodid());

        if(cartJdbc!=null)
        {
            int number = cart.getNumber() + cartJdbc.getNumber();
            int price = number * goods.getGprice();
            cartDao.updateCart(number,price,cartJdbc.getId());
            cart.setNumber(number);
            cart.setPrice(price);
            cart.setId(cartJdbc.getId());
        }
        else
        {
            int price = cart.getNumber() * goods.getGprice();
            cart.setPrice(price);
            cartDao.insertCart(cart);
        }

        return cart;
    }

    @Override
    public PageInfo<Cart> getAllCart(Integer uid, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<Cart> cartList = cartDao.getAllCart(uid);

        //拼接图片url***
        for(Cart cart : cartList)
        {
            String picpath = goodsDao.getGoodpicById(cart.getGoodid());
            cart.setGpicture(imgUrl + picpath);
        }
        PageInfo<Cart> pageInfo = new PageInfo<>(cartList);
        return pageInfo;
    }

    @Override
    public Cart modifyNumber(Integer uid, Integer gid, Integer type) {
        Cart cartJdbc = cartDao.getCartByUGid(uid,gid);
        Goods goods = goodsDao.getGoodById(gid);
        if(cartJdbc!=null)
        {
            int number = cartJdbc.getNumber() + 1 * (type);
            cartJdbc.setNumber(number);
            int price = number * goods.getGprice();
            cartJdbc.setPrice(price);
            cartDao.updateCart(number,price,cartJdbc.getId());
            return cartJdbc;
        }
        return null;
    }

    @Override
    public int deleteOne(Integer id) {
        return cartDao.deleteOne(id);
    }

    @Override
    public int deleteAll(Integer uid) {
        return cartDao.deleteAll(uid);
    }

    @Override
    public int payCart(Integer uid) {
        List<Cart> cartList = cartDao.getAllCart(uid);
        if(cartList.size()==0)
        {
            return 0;
        }
        //插入订单列表
        for(Cart cart : cartList)
        {
            Userorder userorder = new Userorder(cart.getNumber(),cart.getPrice(),
                                                cart.getGoodsname(),cart.getUid(),
                                                cart.getGoodid(),cart.getGpicture());
            // 向订单表插入订单信息
            orderDao.InsertOrder(userorder);

            // 销量增加
            cartDao.updateSales(cart.getGoodid(),cart.getNumber());
        }
        //删除购物车
        return cartDao.deleteAll(uid);
    }
}

