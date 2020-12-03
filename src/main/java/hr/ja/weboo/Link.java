package hr.ja.weboo;

import lombok.Getter;
import org.springframework.web.context.request.WebRequest;

import java.util.function.Function;

//language=InjectedFreeMarker
@Template("""
        <#-- @ftlvariable name="" type="hr.ja.weboo.Link" -->
        <a href=''>${name}</a>
        """)
@Getter
public class Link extends Widget {

    private String name;
    private Function<?, String> method;

    private String href;

    public <T> Link(String name, Function<T, String> method) {
        this.name = name;

        this.method = method;
    }

    @Override
    public String toString() {
        String url = TemplateUtil.getUrlFromMethod(method);
        href = url;
        return super.toString();
    }
}