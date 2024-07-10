package com.webforj.demo;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.applayout.AppLayout.DrawerPlacement;
import com.webforj.demo.widgets.content.ContentDisplay;
import com.webforj.demo.widgets.header.Header;

public class Shell extends Composite<Div>{
  
  Div self = getBoundComponent();
  AppLayout appLayout = new AppLayout();

  public Shell(){
    self.add(appLayout);

    appLayout.addToHeader(new Header());
    appLayout.setDrawerPlacement(DrawerPlacement.HIDDEN);
    appLayout.addToContent(new ContentDisplay());
  }
}
