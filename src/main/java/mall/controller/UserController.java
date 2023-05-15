package mall.controller;

import mall.model.User;
import mall.service.UserService;
import mall.utils.JWTUtils;
import mall.utils.Result;
import mall.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/register")
    public Result<User> register(@RequestBody User user)
    {
        if(userService.registerService(user) != null)
        {
            return Result.success(user);
        }
        else
        {
            return Result.failure(ResultCodeEnum.USER_IS_EXITES);
        }
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User userformjdbc = userService.loginService(user.getUname(),user.getUpassword());
        if(userformjdbc == null)
        {
            return Result.failure(ResultCodeEnum.UNAUTHORIZED,"用户名或密码错误！");
        }
        else
        {
            String token = JWTUtils.getToken(userformjdbc.getUaccount(),userformjdbc.getUname());
            Map<String, String> userMap = new HashMap<String, String>();
            userMap.put("userId",userformjdbc.getUaccount());
            userMap.put("userName",userformjdbc.getUname());
            userMap.put("token",token);
            return Result.success(userMap);
        }
    }
}
