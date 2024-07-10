package icu.sunway.palmzjnubackend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PictureConfig implements WebMvcConfigurer {
    // 需要配置图片静态资源的路径
    @Value("${picture-path.dir}")
    private String picturePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 图片静态资源访问
        registry.addResourceHandler("/api/image/**")
                .addResourceLocations("file:" + picturePath);
    }
}
