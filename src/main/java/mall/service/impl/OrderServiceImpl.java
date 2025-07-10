package mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mall.dao.GoodsDao;
import mall.dao.OrderDao;
import mall.model.Cart;
import mall.model.Userorder;
import mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    OrderDao orderDao;
    @Autowired(required = false)
    GoodsDao goodsDao;
    @Value("${image.prefix-url}")
    String imgUrl;

    @Override
    public PageInfo<Userorder> getAllOrder(Integer uid, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<Userorder> userorderList = orderDao.getAllOrder(uid);

        //拼接图片url***
        for(Userorder userorder : userorderList)
        {
            String picpath = goodsDao.getGoodpicById(userorder.getGid());
            userorder.setGpicture(imgUrl + picpath);
        }

        PageInfo<Userorder> pageInfo = new PageInfo<>(userorderList);
        return pageInfo;
    }

    @Override
    public int deleteOneOrder(Integer id) {
        return orderDao.deleteOneOrder(id);
    }

    @Override
    public int deleteAllOrder(Integer uid) {
        return orderDao.deleteAllOrder(uid);
    }
}