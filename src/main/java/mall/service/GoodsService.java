package mall.service;

import com.github.pagehelper.PageInfo;
import mall.model.Goods;
import org.springframework.stereotype.Service;

@Service
public interface GoodsService {
    //分页查询
    PageInfo<Goods> getAllgoods(Integer pageNum, Integer pageSize);
    Goods getGoodById(Integer gid);

    PageInfo<Goods> getGoodsByTypes(Integer types, Integer pageNum, Integer pageSize);

    PageInfo<Goods> searchGoodsByName(String gname, Integer pageNum, Integer pageSize);

    String getGoodpicById(Integer gid);
}