# webforJ HelloWorld
A simple webforJ HelloWorld project.

```java
package samples;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * A simple HelloWorld app.
 */
@InlineStyleSheet(/* css */"""
    .frame {
      display: inline-grid;
      gap: 20px;
      margin: 20px;
      padding: 20px;
      border: 1px dotted;
    }
      """)
@AppTitle("DWCJ Hello World")
public class WebforjHelloWorld extends App {

  @Override
  public void run() throws DwcjException {

    Frame frame = new Frame();
    frame.addClassName("frame");

    Label label = new Label("Hello World!");

    Button btn = new Button("Say Hello");
    btn.setTheme(ButtonTheme.SUCCESS)
        .setExpanse(Expanse.XLARGE)
        .onClick(e -> msgbox("Hello World!"));

    frame.add(label, btn);
  }
}
```

The result is a modern, responsive HTML5 Web App.

![image](https://github.com/webforj/webforj-hello-world/assets/4313420/7fc147a7-a056-465b-8775-fa218c105bd2)


## Documentations

Check the documentations [here](https://documentation.webforj.com/docs/installation)


