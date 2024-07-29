package com.webforj.demo.pages;

import com.webforj.component.html.elements.Div;

public class Docs extends BasePage<Docs>{
  
  public Docs(){
    Div iframe = new Div();
    iframe.setStyle("height", "100%");
    self.add(iframe);
    iframe.setHtml(/* html */"""
      <iframe
        src="https://documentation.webforj.com/"
        style="width: 100%; height: 100%; border: none; overflow: hidden;"
        loading="lazy">
      </iframe>
    """);
  }
}