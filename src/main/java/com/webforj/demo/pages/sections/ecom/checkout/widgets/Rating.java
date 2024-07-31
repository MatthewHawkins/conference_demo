package com.webforj.demo.pages.sections.ecom.checkout.widgets;

import com.webforj.annotation.Attribute;
import com.webforj.annotation.JavaScript;
import com.webforj.annotation.StyleSheet;
import com.webforj.component.element.ElementComposite;
import com.webforj.component.element.annotation.NodeName;

@StyleSheet("https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.16.0/cdn/themes/light.css")

  @JavaScript(
    value = "https://cdn.jsdelivr.net/npm/@shoelace-style/shoelace@2.0.0-beta.87/dist/shoelace.js",
    attributes = {@Attribute(name = "type", value = "module")
    }
  )
  @NodeName("sl-rating")

  public final class Rating extends ElementComposite {    
    public Rating() {
      super();
    }
  }
