package mall.service.impl;

import mall.dao.UserDao;
import mall.model.User;
import mall.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    //依赖注入
    @Autowired(required = false)
    UserDao userDao;

    @Override
    public User registerService(User user) {
        User tmp = userDao.findByUname(user.getUname());
        if(tmp != null) {
            return null;
        }
        else {
            //密码通过md5算法加密
            String encodePassword = DigestUtils.md5Hex(user.getUpassword());
            user.setUpassword(encodePassword);

            userDao.register(user);
            return user;
        }
    }

    @Override
    public User loginService(String uname,String upassword) {
        //密码通过md5算法加密
        String encodePassword = DigestUtils.md5Hex(upassword);

        return userDao.login(uname,encodePassword);
    }

    @Override
    public User getDetailByUid(Integer uaccount){
        User user = userDao.getDetailByUid(uaccount);
        if(user==null) {
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
