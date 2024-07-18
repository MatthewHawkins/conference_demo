package com.webforj.demo.pages.sections.dashboard.widgets.inbox;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Span;
import com.webforj.component.textarea.TextArea;
import com.webforj.component.button.event.ButtonClickEvent;

import static com.webforj.component.button.ButtonTheme.PRIMARY;

import com.webforj.App;

public class Reply extends Composite<Dialog> {
  Dialog self = getBoundComponent();
  TextField to = new TextField();
  TextField subject = new TextField();
  TextArea text = new TextArea();
  String initialHeader = "<dwc-icon name='send'></dwc-icon> Reply To Message";
  Div headerDiv = new Div();
  String sentHeader = "Message sent!";
  Button send = new Button("Send");
  Button cancel = new Button("Cancel");
  
  public Reply() {
    headerDiv.setHtml(initialHeader);
    self.addToHeader(headerDiv);
    self.setAlignment(Dialog.Alignment.TOP);
    self.setMaxWidth("450px");
    self.addClassName("dialog--reply");
    
    to.setLabel("To:");
    to.setReadOnly(true);
  
    subject.addClassName("dialog__title");
    subject.setLabel("Subject:");
    subject.setPlaceholder("Subject");
    
    text.addClassName("dialog__message");
    text.setAttribute("label", "Message:");
    
    Div dialogContent = new Div();
    dialogContent.addClassName("dialog__content")
        .add(to, subject, text);
    self.addToContent(dialogContent);

    send.setTheme(PRIMARY);
    send.addClassName("button__reply");
    send.onClick(this::handleButtonClick);
  
    cancel.onClick(this::handleButtonClick);
    cancel.addClassName("button__reply");
  
    self.addToFooter(send, cancel);
  }

  /**
   * Show the dialog.
   */
  public void show(String to, String text) {
    this.to.setText(to);
    this.text.setText(text + "\n");
    self.open();
  }

  private void handleButtonClick(ButtonClickEvent event) {
    if (event.getComponent().getText().equals("Send")) {
      headerDiv.setHtml(sentHeader);
      headerDiv.addClassName("message-sent");
      to.setVisible(false);
      subject.setVisible(false);
      text.setVisible(false);
      send.setVisible(false);
      cancel.setText("Close");
    } else {
      self.close();
      App.consoleLog("self: " + self.getComponentId());
      headerDiv.setHtml(initialHeader);
      to.setVisible(true);
      subject.setVisible(true);
      text.setVisible(true);
      send.setVisible(true);
    }
    to.setText("");
    subject.setText("");
    text.setText("");
  }
}