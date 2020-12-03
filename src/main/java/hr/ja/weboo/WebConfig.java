package hr.ja.weboo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
//@Configuration
//@EnableWebMvc

public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyLayoutInterceptor());
    }

    //@Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        log.info("Freemarkser");
        FreeMarkerConfigurer freemarkerConfig = new FreeMarkerConfigurer();
      //  freemarkerConfig.setTemplateLoaderPath("template");
        freemarkerConfig.setDefaultEncoding("UTF-8");
//        Map<String, Object> freemarkerVariables = new HashMap<String, Object>();
//        freemarkerVariables.put("layout", freemarkerLayoutDirectives());
//        freemarkerConfig.setFreemarkerVariables(freemarkerVariables);


        return freemarkerConfig;
    }
}
