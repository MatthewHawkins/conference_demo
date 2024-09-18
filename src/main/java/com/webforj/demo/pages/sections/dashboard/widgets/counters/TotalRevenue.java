package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.component.html.elements.Div;

public final class TotalRevenue extends Div {
    
  public TotalRevenue() {
    AnimatedCounter counter = new AnimatedCounter("Total Revenue", 95808.947);
    counter.setPrefix("&euro;")
      .setIcon("currency-euro")
      .setTheme(AnimatedCounter.Theme.PRIMARY);
    add(counter);
    setStyle("flex", "1 1 19%");
  }

}
