package mall.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mall.utils.JWTUtils;
import mall.utils.Result;
import mall.utils.ResultCodeEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTInterceptors implements HandlerInterceptor {
    //ctrl + i
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String message="";
        // 获取请求头中令牌
        String token = request.getHeader("token");

        try {
            // 验证令牌
            JWTUtils.verify(token);
            return true;  // 放行请求

        } catch (SignatureVerificationException e) {
//            e.printStackTrace();
            message="无效签名！";
        }catch (TokenExpiredException e){
//            e.printStackTrace();
            message="token过期";
        }catch (AlgorithmMismatchException e){
//            e.printStackTrace();
            message="算法不一致";
        }catch (Exception e){
//            e.printStackTrace();
            message="token 为空或无效！";
        }
        // 将HttpResult以json的形式响应到前台  HttpResult --> json  (jackson) data
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(Result.failure(ResultCodeEnum.UNAUTHORIZED,message));
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
