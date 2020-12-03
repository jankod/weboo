package hr.ja.weboo;

import lombok.Data;
import lombok.Getter;

@Data
//language=InjectedFreeMarker
@Template("""
        <#-- @ftlvariable name="" type="hr.ja.weboo.MyPage" -->
        <p>Ovo je page </p>
        <p>Label ${label}</p>
        """)
public class MyPage extends Widget {

    @Getter
    private MyLabel label;

    MyPage() {
        label = new MyLabel("janko");
    }


}
