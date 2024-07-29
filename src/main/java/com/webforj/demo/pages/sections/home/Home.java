package com.webforj.demo.pages.sections.home;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.JavaScript;
import com.webforj.demo.pages.BasePage;
import com.webforj.demo.pages.sections.home.widgets.AppLayoutSample;
import com.webforj.demo.pages.sections.home.widgets.CounterSample;
import com.webforj.demo.pages.sections.home.widgets.Header;
import com.webforj.demo.pages.sections.home.widgets.QRCodeSample;

@JavaScript(value = "https://cdn.jsdelivr.net/npm/lazysizes@5.3.2/lazysizes.min.js")
@InlineStyleSheet(id = "javaland-page-home", value = "context://public/pages/home/home.css", once = true)

public final class Home extends BasePage<Home> {

  public Home() {
    self.addClassName("page page--home");

    self.add(new Header());
    self.add(new CounterSample());
    self.add(new AppLayoutSample());
    self.add(new QRCodeSample());
  }
  
}