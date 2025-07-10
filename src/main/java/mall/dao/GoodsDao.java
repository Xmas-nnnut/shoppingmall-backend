package mall.dao;

import mall.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    List<Goods> getAllgoods();
    Goods getGoodById(Integer gid);

    List<Goods> getGoodByTypes(Integer types);

    List<Goods> searchGoodsByName(String gname);

    String getGoodpicById(Integer gid);
}