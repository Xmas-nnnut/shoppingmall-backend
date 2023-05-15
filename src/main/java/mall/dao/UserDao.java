package mall.dao;

import mall.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    //注册
    int register(User user);
    //根据用户名搜索
    User findByUname(String uname);
    //登录
    User login(String uname,String upassword);
}
