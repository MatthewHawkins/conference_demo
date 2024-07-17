package com.webforj.demo.pages.sections.dashboard.widgets.counters;

import com.webforj.component.html.elements.Div;

public final class TodayVisits extends Div {

  public TodayVisits() {
    AnimatedCounter counter = new AnimatedCounter("Today's Visits", 78.41);
    counter.setSuffix("K")
      .setIcon("eye")
      .setTheme(AnimatedCounter.Theme.WARNING);
    add(counter);
    setStyle("flex", "1 1 19%");
  }
    
}
