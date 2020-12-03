package hr.ja.weboo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@RequestScope
@RequiredArgsConstructor
public class MyController {

    private final TemplateUtil templateUtil;

    private int counter = 1;

    @GetMapping("/")
    @ResponseBody
    public String index() {

        MyPage p = new MyPage();

        return templateUtil.parse(p) + " <p>" + counter++ + "</p>";

    }
}
