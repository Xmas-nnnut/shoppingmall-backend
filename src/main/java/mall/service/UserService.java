package mall.service;

import mall.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerService(User user);
    User loginService(String uname,String upassword);

    User getDetailByUid(Integer uaccount);
    int updateUserInfo(User user);
}
