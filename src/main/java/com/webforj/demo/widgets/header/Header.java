package com.webforj.demo.widgets.header;

import com.webforj.App;
import com.webforj.Request;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.Composite;
import com.webforj.component.Expanse;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.component.tabbedpane.event.TabSelectEvent;
// import com.webforj.demo.pages.sections.home.Home;
// import com.webforj.demo.pages.Home;
import com.webforj.kitchen.simplerouter.SimpleRouter;
// import com.webforj.addons.services.simplerouter.SimpleRouter;

@InlineStyleSheet( /*css */"""
  :root{
    --dwc-app-layout-header-collapse-height: 47px;  
  }

  .header{
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0px 30px;
  }

  .logo{
    max-width: 150px;
    margin-right: -150px;
  }
""")
public class Header extends Composite<Div> {
  Div self = getBoundComponent();
  Img logo = new Img("https://documentation.webforj.com/img/webforj.svg");
  TabbedPane tabs = new TabbedPane();
  ThemeToggle themeToggle = new ThemeToggle();

  private SimpleRouter router = SimpleRouter.getInstance();
  int selectedIndex;
  int currentPageIndex;

  public Header(){
    self.add(logo, tabs, themeToggle);
    self.addClassName("header");

    logo.addClassName("logo");
    
    tabs.addTab("<html> <dwc-icon name=home></dwc-icon> Home");
    tabs.addTab("<html> <dwc-icon name=dashboard></dwc-icon> Dashboard");
    tabs.addTab("<html> <dwc-icon name=shopping-cart></dwc-icon> Ecom");
    tabs.addTab("<html> <dwc-icon name=book></dwc-icon> Documentation");
    tabs.addClassName("tabs");
    tabs.setBorderless(true);
    tabs.setExpanse(Expanse.LARGE);
    tabs.setBodyHidden(true);

    tabs.onSelect(this::navigate);

    String currentPath = App.getUrl(); 
    // String currentPath = Request.getUrl(); 
    String route = currentPath.replaceAll(".*/([^/?#]+).*", "$1");
    switch (route) {
      case "home":
        currentPageIndex = 0;
        break;
      case "dashboard":
        currentPageIndex = 1;
        break;
      case "ecom":
        currentPageIndex = 2;
        break;
      case "documentation":
        currentPageIndex = 3;
        break;
      case "docs":
        currentPageIndex = 3;
    }
    tabs.select(currentPageIndex);
  }

  private void navigate(TabSelectEvent e){
    if(selectedIndex == e.getTabIndex()){
      return;
    }
    selectedIndex = e.getTabIndex();

    String page = e.getTab().getTitle().replaceAll("<[^>]*>", "").trim().toLowerCase();
    if (page.equals("documentation")) {page = "docs";}
    router.navigate(page);
  }
}
