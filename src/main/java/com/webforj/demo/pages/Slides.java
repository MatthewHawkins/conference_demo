package com.webforj.demo.pages;

import com.webforj.component.html.elements.Div;

public class Slides extends BasePage<Slides>{
  public Slides(){
    Div iframe = new Div();
    iframe.setStyle("height", "100%");
    self.add(iframe);
    iframe.setHtml(/* html */"""
      <iframe
        src="https://docs.google.com/presentation/d/1Yrfv62S8BZLB_deaI4StI76CcyaFf3y4/preview?usp=sharing&ouid=113176100594178159844&rtpof=true&sd=true"
        style="width: 100%; height: 50%; border: none; overflow: hidden;"
        loading="lazy">
      </iframe>
    """);
  }
}
