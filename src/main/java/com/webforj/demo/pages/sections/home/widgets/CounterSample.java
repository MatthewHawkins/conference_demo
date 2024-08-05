package com.webforj.demo.pages.sections.home.widgets;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.layout.flexlayout.FlexJustifyContent;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.utilities.Assets;

public class CounterSample extends Composite<FlexLayout> {
  private int count = 0;

  public CounterSample() {
    getBoundComponent().setJustifyContent(FlexJustifyContent.CENTER);
    Div sample = new Div();
    getBoundComponent().add(sample);
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
        <h2>Easy to Start.</h2>
        <p>
          Creating your application in webforJ is simple -  use our extensive library of feature-rich and robust components to
          start building your application with a few lines of Java or Kotlin code!
        </p>
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
    application.setText(Assets.contentOf("public/pages/home/code/counter/Application.java"));
    
    CodeDisplay applicationKt = new CodeDisplay();
    tabs.addTab("App.kt", applicationKt);
    applicationKt.setLanguage("java");
    applicationKt.setText(Assets.contentOf("public/pages/home/code/counter/Application.kt"));

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javaland-sample__result javaland-sample__result-center");

    Div title = new Div();
    title.setHtml(/* html */"""
      <html>
        <h3 style="margin: 0">Simple Counter</h3>
      </html>
    """);
    title.setStyle("white-space", "normal");
    result.add(title);

    Paragraph text = new Paragraph("Count: 0");
    result.add(text);

    Button button = new Button("Counter");
    result.add(button);
    button.onClick(e -> {
      count++;
      text.setText("Count: " + count);
    });
  }
}
