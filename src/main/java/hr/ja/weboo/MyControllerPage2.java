package hr.ja.weboo;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;

//language=InjectedFreeMarker
@Template("""
        <#-- @ftlvariable name="" type="hr.ja.weboo.MyControllerPage2" -->
        <p>   asa asd asasdsaage 2 je</p>

        <p>Conter ${counter} &&  < > </p>
                
        <div>My html ${myHtml}</div>
        
        <div>${link}</div>
        """)
@Getter
@Controller
@RequestScope
@RequiredArgsConstructor
@Slf4j
public class MyControllerPage2 extends Widget {

    private int counter = 1;

    private String myHtml = "ja sam <br> < > Ovo je paragraf '<p> </p>'";

    private Link link = new Link("klikni me <b>ddd      ", this::clickLink);


    @GetMapping("/click_link")
    private String clickLink(WebRequest req) {

        return "template";
    }


    @GetMapping("/page2")
    public String request(Model model) {

        counter++;
        model.addAttribute("page", TemplateUtil.parse(this));
        model.addAttribute("title", "page 2");

        return "template";
    }
}
