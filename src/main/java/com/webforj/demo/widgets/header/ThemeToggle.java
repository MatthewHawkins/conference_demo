package com.webforj.demo.widgets.header;

import com.webforj.App;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.event.HtmlClickEvent;

public class ThemeToggle extends Composite<Div>{
  
  Div self = getBoundComponent();

  public ThemeToggle(){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
    } else{
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
    }
    self.setStyle("height", "var(--dwc-size-l)");
    self.setStyle("align-content", "center");
    self.onClick(this::toggleTheme);
  }
  
  public void toggleTheme(HtmlClickEvent e){
    if(App.getTheme().equals("light")){
      self.setHtml("<dwc-icon name=moon></dwc-icon>");
      App.setTheme("dark");
    } else{
      self.setHtml("<dwc-icon name=sun></dwc-icon>");
      App.setTheme("light");
    }
  }

}
