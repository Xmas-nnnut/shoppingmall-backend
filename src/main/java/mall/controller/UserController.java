package mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    //依赖注入
    @Autowired
    UserService userService;
    //注册接口
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
            //构建返回体
            Map<String, String> userMap = new HashMap<String, String>();
            userMap.put("userId",userformjdbc.getUaccount());
            userMap.put("userName",userformjdbc.getUname());
            userMap.put("token",token);
            return Result.success(userMap);
        }
    }

    @ApiOperation("根据用户id获取用户信息详情")
    @ApiImplicitParam(name = "uaccount",value = "用户id",dataTypeClass = Integer.class,required = true,defaultValue = "1")
    @GetMapping("/detail/{uaccount}")
    public Result detail( @PathVariable(name = "uaccount")Integer uaccount)
    {
        User user = userService.getDetailByUid(uaccount);
        return Result.success(user);
    }

    @ApiOperation("根据用户id修改用户信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "uaccount",value = "用户id",dataTypeClass = Integer.class,defaultValue = "1"),
            @ApiImplicitParam(name = "usex",value = "用户性别",dataTypeClass = String.class,defaultValue = "男"),
            @ApiImplicitParam(name = "uaddress",value = "用户地址",dataTypeClass = String.class,defaultValue = "福建省"),
            @ApiImplicitParam(name = "utel",value = "电话",dataTypeClass = String.class,defaultValue = "114514"),
    })
    @PutMapping("/updateUserInfo")
    public Result updateUserInfo( @RequestParam(name = "uaccount") Integer uaccount,
                                  @RequestParam(name = "usex") String usex,
                                  @RequestParam(name = "uaddress") String uaddress,
                                  @RequestParam(name = "utel") String utel)
    {
        User user = userService.getDetailByUid(uaccount);

        if (user == null) {
            // 如果该用户不存在，响应相应的结果
            return Result.failure(ResultCodeEnum.FAIL,"该用户不存在！");
        } else {
            // 修改用户信息
            user.setUsex(usex);
            user.setUaddress(uaddress);
            user.setUtel(utel);

            // 更新用户信息
            int rows = userService.updateUserInfo(user);

            if (rows <= 0) {
                // 更新操作未产生影响
                return Result.failure(ResultCodeEnum.FAIL,"更新用户信息失败！");
            } else {
                // 更新操作成功
                return Result.success(rows);
            }
        }

    }
}
