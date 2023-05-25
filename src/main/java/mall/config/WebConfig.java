package mall.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.save-path}")
    String filePath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //其中img表示访问的前缀。"file:"是文件真实的存储路径
        registry.addResourceHandler("/img/**").addResourceLocations("file:"+filePath);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptors()).
                addPathPatterns("/**")//所有接口进行拦截
                .excludePathPatterns("/user/login","/user/register")//登录、注册放行
                .excludePathPatterns("/goods/**")//放行商品
                .excludePathPatterns("/img/**")//放行图片
                .excludePathPatterns("/swagger-resources/**","/swagger-ui/**", "/v3/**", "/error");//放行swagger
    }
}
