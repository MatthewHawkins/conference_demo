package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.component.html.elements.Div;

public final class TodaySales extends Div {
    
  public TodaySales() {
    AnimatedCounter counter = new AnimatedCounter("Today's Sales", 2180);
    counter.setPrefix("&euro;")
      .setIcon("shopping-cart")
      .setTheme(AnimatedCounter.Theme.SUCCESS);
    add(counter);
    setStyle("flex", "1 1 19%");
  }
}
