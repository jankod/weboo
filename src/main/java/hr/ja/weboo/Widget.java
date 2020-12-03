package hr.ja.weboo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Widget {

//    public void setTemplate(String template) {
//        TemplateHolder.setTemplate(this, template);
//    }
//
//    public Widget() {
//        TemplateParser.checkThis(this);
//    }


    @Override
    public String toString() {
      //  log.debug("parse {}", this.getClass());
        //return TemplateParser.parseWidget(this);
        return TemplateUtil.parse(this);
    }

//    protected static void html(String html, Class<? extends Widget> c) {
//        TemplateHolder.setTemplate2(c, html);
//    }
}
