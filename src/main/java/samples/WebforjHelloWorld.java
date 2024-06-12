package samples;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

/**
 * A simple HelloWorld app.
 */
@InlineStyleSheet(/* css */"""
  .mainFrame {
    display: inline-grid;
    gap: 20px;
    margin: 20px;
    padding: 20px;
    border: 1px dashed;
    border-radius: 10px;
  }
""")
@AppTitle("webforJ Hello World")
public class WebforjHelloWorld extends App {
  
  Paragraph hello = new Paragraph("Hello World!");
  Button btn = new Button("Say Hello");

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();
    mainFrame.addClassName("mainFrame");

    btn.setTheme(ButtonTheme.PRIMARY)
        .addClickListener(e -> showMessageDialog("Hello World!", "webforJ Message"));

    mainFrame.add(hello, btn);
  }
}
