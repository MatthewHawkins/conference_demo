package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.component.html.elements.Div;

public final class Conversion extends Div {

  public Conversion() {
    AnimatedCounter counter = new AnimatedCounter("Conversion", .58);
    counter.setSuffix("%")
      .setIcon("chart-bar")
      .setTheme(AnimatedCounter.Theme.INFO);
    add(counter);
    setStyle("flex", "1 1 19%");
  }
    
}
