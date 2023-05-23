package mall.service.impl;

import mall.dao.UserDao;
import mall.model.Goods;
import mall.model.User;
import mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    UserDao userDao;

    @Override
    public User registerService(User user) {
        User tmp = userDao.findByUname(user.getUname());
        if(tmp != null)
        {return null;}
        else
        {
            userDao.register(user);
            return user;
        }
    }

    @Override
    public User loginService(String uname,String upassword) {
        return userDao.login(uname,upassword);
    }

    @Override
    public User getDetailByUid(Integer uaccount){
        User user = userDao.getDetailByUid(uaccount);
        if(user==null)
        {
            return null;
        }
        return user;
    }

    @Override
    public int updateUserInfo(User user){
        int tmp = userDao.updateUserInfo(user);
        return tmp;
    }

}
