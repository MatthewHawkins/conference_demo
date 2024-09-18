package com.webforj.demo.widgets.header;

import com.webforj.App;
import com.webforj.Page;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.element.event.ElementClickEvent;
import com.webforj.component.html.elements.Div;

@InlineStyleSheet(id = "javaland-page-home", value = "context://public/pages/home/home.css", once = true)

public class ThemeToggle extends Composite<Div>{
  
  Div self = getBoundComponent();

  public ThemeToggle(){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
    } else{
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
    }
    self.addClassName("button__theme-toggle");
    self.onClick(this::toggleTheme);
  }
  
  public void toggleTheme(ElementClickEvent e){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
      App.setTheme("dark");
      Page.getCurrent().executeJsVoidAsync("""
        var iframe = document.getElementById('app_layout_iframe');
        if (iframe) {
            var iframeContent = iframe.contentWindow;
            if (iframeContent && iframeContent.document) {
                var htmlTag = iframeContent.document.querySelector("html");
                htmlTag.setAttribute("data-app-theme", "dark");
            }
          }
          """);
    } else{
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
      App.setTheme("light");
      Page.getCurrent().executeJsVoidAsync("""
        var iframe = document.getElementById('app_layout_iframe');
        if (iframe) {
            var iframeContent = iframe.contentWindow;
            if (iframeContent && iframeContent.document) {
                var htmlTag = iframeContent.document.querySelector("html");
                htmlTag.setAttribute("data-app-theme", "light");
            }
          }
          """);
    }
  }

}
