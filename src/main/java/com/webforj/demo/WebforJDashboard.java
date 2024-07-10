package com.webforj.demo;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

@AppTitle("webforJ Dashboard")
@InlineStyleSheet(id = "javaland-typography", value = "context://css/typography.css", once = true)
public class WebforJDashboard extends App {
  
  Frame mainFrame;

  @Override
  public void run() throws WebforjException {
    mainFrame = new Frame();
    mainFrame.add(new Shell());
  }
}
