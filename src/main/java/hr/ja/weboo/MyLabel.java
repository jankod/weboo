package hr.ja.weboo;

import lombok.Getter;

//language=InjectedFreeMarker
@Template("""
            <#-- @ftlvariable name="" type="hr.ja.weboo.MyLabel" -->
            
            <p>Ovo je label 2: ${label?upper_case}</p>
            
            """)
@Getter
public class MyLabel extends Widget {

    private String label;


    public MyLabel(String label) {
        this.label = label;
    }
}
