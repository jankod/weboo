package hr.ja.weboo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.nio.charset.StandardCharsets;

@Slf4j
public class MyLayoutInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            log.info("Handle " + handler.getClass());
            Class<?> beanType = ((HandlerMethod) handler).getBeanType();
            //log.info("bean type {}", beanType.getAnnotation(Template.class));
            Annotation annotation = beanType.getAnnotation(Template.class);
            //log.info("annot {}", annotation);
            if (annotation != null)


            //language=InjectedFreeMarker
            {
                String html = """
                        <html>
                        <head>
                        </head>
                        <body>
                        """;
                response.getOutputStream().println(html);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.debug("post handle");
        //language=InjectedFreeMarker
        String s = """
                </body>
                </html>
                """;
        response.getOutputStream().write(s.getBytes(StandardCharsets.UTF_8));
    }
}
