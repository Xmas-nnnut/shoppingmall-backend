package mall.dao;

import mall.model.Userorder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    int InsertOrder(Userorder userorder);
    List<Userorder> getAllOrder(Integer uid);
    int deleteOneOrder(Integer id);
    int deleteAllOrder(Integer uid);
}