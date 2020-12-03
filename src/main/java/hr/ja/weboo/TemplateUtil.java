package hr.ja.weboo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;


@Slf4j
@Component
public class TemplateUtil {


    private static FreeMarkerConfigurer freemarkerStatic;
    private static RequestMappingHandlerMapping handlerMappingStatic;


    public TemplateUtil(FreeMarkerConfigurer freemarker, RequestMappingHandlerMapping handlerMapping) {
        freemarkerStatic = freemarker;
        handlerMappingStatic = handlerMapping;
    }


    public static String parse(Object w) {
// TODO add cache to template
        try {
            String template = getTemplateFromWidget(w);
            //template = "<#ftl output_format=\"HTML\" strip_whitespace=true> \n" + template;
            Template t = new Template(w.getClass().getName(), new StringReader(template), freemarkerStatic.getConfiguration());

            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, w);

            return html;
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
            return "Errors " + e.getMessage();
        }
    }

    private static String getTemplateFromWidget(Object w) {

        hr.ja.weboo.Template template = w.getClass().getAnnotation(hr.ja.weboo.Template.class);
        return template.value();
    }

    public static String getUrlFromMethod(Function<?, String> method) {
        Set<Map.Entry<RequestMappingInfo, HandlerMethod>> entries = handlerMappingStatic.getHandlerMethods().entrySet();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : entries) {
            if (entry.getValue().equals(method)) {
                log.info("Found method {}", method);
                Set<String> directPaths = entry.getKey().getDirectPaths();
                String url = directPaths.iterator().next();
                return url;
            }
        }
        return "Some url no find";
    }
}
