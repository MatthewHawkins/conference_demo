package com.webforj.demo.pages.sections.home.widgets;

import com.webforj.component.html.elements.Div;
import com.webforj.component.tabbedpane.TabbedPane;
import com.webforj.utilities.Assets;

public class AppLayoutSample extends Div {

  public AppLayoutSample() {
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
        <h2>Simple to Scale.</h2>
        <p>
          As your application scales up,the webforJ framework has you covered! It provides robust and responsive tools, such as the App Layout component, to help quickly and easily make your application ready to meet the needs of your business.
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
    application.setText(Assets.contentOf("public/pages/home/code/applayout/Application.java"));

    // 2 Result
    // =================
    Div result = new Div();
    sample.add(result);
    result.addClassName("javaland-sample__result");

    Div iframe = new Div();
    iframe.setStyle("height", "100%");
    result.add(iframe);
    iframe.addClassName("javaland-sample__iframe");
    iframe.setHtml(/* html */"""
      <iframe
        class="lazyload applayout__iframe"
        id="app_layout_iframe"
        src="https://eu.bbx.kitchen/webapp/controlsamples/AppLayoutConferenceDemo?"
        style="width: 100%; height: 100%; border: none;overflow: hidden;"
        loading="lazy">
      </iframe>
    """);
  }
  
}