package com.webforj.demo.widgets.content;

import java.util.HashMap;
import java.util.Map;

import com.webforj.App;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.demo.pages.BasePage;
import com.webforj.demo.pages.Dashboard;
import com.webforj.demo.pages.Home;
import com.webforj.demo.pages.Ecom;
import com.webforj.demo.pages.Docs;
import com.webforj.kitchen.simplerouter.SimpleRouter;
import com.webforj.kitchen.simplerouter.event.SimpleRouteMatchEvent;

public class ContentDisplay extends Composite<Div> {

  Div self = getBoundComponent();

  private SimpleRouter router = SimpleRouter.getInstance();

  BasePage<?> currentPage;
  private Map<String, BasePage<?>> pages = new HashMap<>();

  public ContentDisplay() {
    self.setStyle("height", "100%");

    initRoutes();
    router.navigate();
  }

  private void initRoutes() {
    router.onRouteMatch(this::onRouteMatch,
        "home/*",
        "dashboard/*",
        "ecom/*",
        "docs/*");
  }

  private void onRouteMatch(SimpleRouteMatchEvent ev) {
    String matchingRoute = ev.getRoute().getRoute();
    if (pages.containsKey(matchingRoute)) {
      handleDisplay(matchingRoute);
    } else {
      registerPage(matchingRoute);
    }
  }

  public void registerPage(String route) {
    if (route.equals("dashboard/*")) {
      Dashboard dashboard = new Dashboard();
      pages.put("dashboard/*", dashboard);
      self.add(dashboard);
    } else if (route.equals("ecom/*")) {
      Ecom ecom = new Ecom();
      pages.put("ecom/*", ecom);
      self.add(ecom);
    } else if (route.equals("docs/*")) {
      Docs docs = new Docs();
      pages.put("docs/*", docs);
      self.add(docs);
    } else {
      Home home = new Home();
      pages.put("home/*", home);
      self.add(home);
    }
    handleDisplay(route);
  }

  private void handleDisplay(String route) {
    if(currentPage != null){
      currentPage.setVisible(false);
    }
    pages.get(route).setVisible(true);
    currentPage = pages.get(route);
  }
}
