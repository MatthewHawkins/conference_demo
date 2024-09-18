import com.webforj.exceptions.WebforjException;

public class AppTemplateDemo extends App {
  AppTemplateMobile layout = new AppTemplateMobile();  

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();

    //...
    layout.addPage("Dashboard", "dashboard", new Div())
    .addPage("Orders", "shopping-cart", new Div())
    .addPage("Customers", "users", new Div())
    .addPage("Products", "box", new Div())
    .addPage("Documents", "files", new Div())
    .addPage("Tasks", "checklist", new Div())
    .addPage("Analytics", "chart-dots-2", new Div());
    //...
    
    mainFrame.add(layout);
  }
}

public class Application {
    
}
