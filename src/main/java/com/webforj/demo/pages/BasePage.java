package com.webforj.demo.pages;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.concern.HasVisibility;


public abstract class BasePage<B extends BasePage<B>> extends Composite<Div> implements HasVisibility<B>{
  
  protected final Div self = getBoundComponent();
  
  protected BasePage(){
    self.setStyle("height", "100%");
    self.setStyle("width", "100%");
  }

  @Override
  protected Div initBoundComponent() {
    return new Div();
  }

  @Override
  public B setVisible(boolean visible) {
    self.setVisible(visible);
    return (B) this;
  }
}
