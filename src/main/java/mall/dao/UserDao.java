package mall.dao;

import mall.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    //注册
    int register(User user);
    //根据用户名搜索，判断有没有重名
    User findByUname(String uname);
    //登录
    User login(String uname,String upassword);

    //获取用户信息
    User getDetailByUid(Integer uaccount);
    //更改用户信息
    int updateUserInfo(User user);
}
