package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.component.html.elements.Div;

public final class Target extends Div {
    
  public Target() {
    AnimatedCounter counter = new AnimatedCounter("Target", 117306.00);
    counter.setPrefix("&euro;")
      .setIcon("target")
      .setTheme(AnimatedCounter.Theme.DANGER);
    add(counter);
    setStyle("flex", "1 1 19%");
  }
    
}
