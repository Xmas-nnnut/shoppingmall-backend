package mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import mall.model.Goods;
import mall.model.User;
import mall.service.UserService;
import mall.utils.JWTUtils;
import mall.utils.Result;
import mall.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "1-用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @ApiOperation("用户注册")
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

    @ApiOperation("用户登录")
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

    @ApiOperation("根据用户id获取商品详情")
    @ApiImplicitParam(name = "uaccount",value = "用户id",dataTypeClass = String.class,required = true,defaultValue = "1")
    @GetMapping("/detail/{uaccount}")
    public Result detail( @PathVariable(name = "uaccount")Integer uaccount)
    {
        User user = userService.getDetailByUid(uaccount);
        return Result.success(user);
    }
}
