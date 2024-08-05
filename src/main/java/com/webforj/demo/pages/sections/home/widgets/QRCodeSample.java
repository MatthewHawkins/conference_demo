package com.webforj.demo.pages.sections.home.widgets;

import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.demo.pages.sections.home.widgets.QRCode;
import com.webforj.utilities.Assets;

public class QRCodeSample extends Div {

  public QRCodeSample() {

    Div sample = new Div();
    add(sample);
    sample.addClassName("javaland-sample");

    // 1 Content
    // =================
    Div content = new Div();
    sample.add(content);
    content.addClassName("javaland-sample__content");

    // 1.1 Description
    // =================
    Div description = new Div();
    content.add(description);
    description.addClassName("javaland-sample__description");
    description.setHtml(/* html */"""
      <html>
        <h2>Web Components.</h2>
        <p>Reach outside of the extensive set of webforJ core components by importing your favorite web components using webforJ's web component API. Utilize any open-source web component library, or create your own for use in your application.</p>
      </html>
    """);

    // 1.2 Tabs
    // =================
    TabbedPane tabs = new TabbedPane();
    content.add(tabs);
    tabs.addClassName("javaland-sample__tabs");

    CodeDisplay application = new CodeDisplay();
    tabs.addTab("App.java", application);
    application.setLanguage("java");
    application.setText(Assets.contentOf("public/pages/home/code/qrcode/QRCodeApplication.java"));

    CodeDisplay component = new CodeDisplay();
    tabs.addTab("QRCode.java", component);
    component.setLanguage("java");
    component.setText(Assets.contentOf("public/pages/home/code/qrcode/QRCode.java"));
    tabs.select(1);

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javaland-sample__result javaland-sample__result-center");

    Div title = new Div();
    title.setHtml(/* html */"""
      <html>
        <h3 style="margin: 0">QRCode Generator</h3>
      </html>
    """);
    title.setStyle("white-space","normal");
    result.add(title);

    QRCode qr = new QRCode();
    result.add(qr);
    qr.setColor(new java.awt.Color(0, 86, 179));

    TextField input = new TextField();
    result.add(input);
    input.setText(qr.getValue());
    input.setPlaceholder("Enter a value");
    input.onModify((e) -> {
      qr.setValue(input.getText());
    });
  }
}
