package mall.service;

import com.github.pagehelper.PageInfo;
import mall.model.Userorder;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    PageInfo<Userorder> getAllOrder(Integer uid, Integer pageNum, Integer pageSize);
    int deleteOneOrder(Integer id);
    int deleteAllOrder(Integer uid);
}