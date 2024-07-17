package com.webforj.demo.pages.sections.dashboard;

import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.html.elements.Div;
import com.webforj.demo.pages.BasePage;
import com.webforj.demo.pages.sections.dashboard.widgets.TopSelling;
import com.webforj.demo.pages.sections.dashboard.widgets.charts.LastSales;
import com.webforj.demo.pages.sections.dashboard.widgets.charts.LifetimeSales;
import com.webforj.demo.pages.sections.dashboard.widgets.charts.ProjectionsVsActual;
import com.webforj.demo.pages.sections.dashboard.widgets.charts.RevenueLocation;
import com.webforj.demo.pages.sections.dashboard.widgets.counters.Target;
import com.webforj.demo.pages.sections.dashboard.widgets.counters.TodaySales;
import com.webforj.demo.pages.sections.dashboard.widgets.counters.TotalRevenue;
import com.webforj.demo.pages.sections.dashboard.widgets.inbox.Inbox;
import com.webforj.demo.pages.sections.dashboard.widgets.teamcards.TeamCardDisplay;
import com.webforj.demo.pages.sections.dashboard.widgets.todo.ToDo;

@InlineStyleSheet("context://public/pages/dashboard.css")

public class Dashboard extends BasePage<Dashboard> {
  
  public Dashboard() {
    setVisible(false);
    self.addClassName("page page--dashboard");

    Div counters = new Div();
    counters.addClassName("countersWrapper");
    counters.add(new TotalRevenue());
    counters.add(new Target());
    counters.add(new TodaySales());

    Div quarterCharts = new Div();
    quarterCharts.addClassName("chartsWrapper");
    quarterCharts.add(new RevenueLocation());
    quarterCharts.add(new LifetimeSales());

    Div lifeTimeCharts = new Div();
    lifeTimeCharts.addClassName("chartsWrapper");
    lifeTimeCharts.add(new LastSales());
    lifeTimeCharts.add(new ProjectionsVsActual());

    Div teamCards = new Div();
    teamCards.add(new TeamCardDisplay());

    Div apps = new Div();
    apps.addClassName("appsWrapper");
    apps.add(new ToDo());
    apps.add(new Inbox());

    self.add(
      counters,
      quarterCharts,
      new TopSelling(),
      lifeTimeCharts,
      teamCards,
      apps
    );

    setVisible(true);
  }
    
}
