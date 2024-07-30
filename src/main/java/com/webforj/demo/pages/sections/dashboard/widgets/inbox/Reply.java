package com.webforj.demo.pages.sections.dashboard.widgets.inbox;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.TextArea;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.button.event.ButtonClickEvent;

import static com.webforj.component.button.ButtonTheme.PRIMARY;

import java.util.Timer;
import java.util.TimerTask;

import com.webforj.App;

public class Reply extends Composite<Dialog> {
  Dialog self = getBoundComponent();
  TextField to = new TextField("To:");
  TextField subject = new TextField("Subject:");
  TextArea text = new TextArea();
  Div headerDiv = new Div();
  String initialHeader = "<dwc-icon name='send'></dwc-icon> Reply To Message";
  String sentHeader = "Message sent!";
  Div noSubject = new Div("Subject cannot be blank");
  Button send = new Button("Send");
  Button cancel = new Button("Cancel");
  
  public Reply() {
    headerDiv.setHtml(initialHeader);
    self.setAlignment(Dialog.Alignment.TOP)
      .setMaxWidth("450px")
      .addClassName("dialog--reply")
      .setBlurred(true)
      .setCancelOnOutsideClick(false);
    self.addToHeader(headerDiv);
    
    to.setReadOnly(true);
  
    subject.addClassName("dialog__title")
      .setPlaceholder("Subject");
    
    text.addClassName("dialog__message")
      .setLabel("Message:");
    
    Div dialogContent = new Div();
    dialogContent.addClassName("dialog__content")
        .add(to, subject, text);
    self.addToContent(dialogContent);

    send.setTheme(PRIMARY)
      .addClassName("button__reply")
      .onClick(this::handleButtonClick);
  
    cancel.addClassName("button__reply")
      .onClick(this::handleButtonClick);

    noSubject.addClassName("reply-form__no-subject-warning");

    self.addToFooter(noSubject, send, cancel);
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
      if (subject.getText().length() > 0) {
        headerDiv.setHtml(sentHeader)
          .addClassName("message-sent");
        to.setVisible(false);
        subject.setVisible(false);
        text.setVisible(false);
        send.setVisible(false);
        cancel.setText("Close");
      } else {
        noSubject.setStyle("display", "block");
        self.addClassName("reply-form-container__no-subject");
        new Timer().schedule(
          new TimerTask() {
            @Override
            public void run() {
              noSubject.setStyle("display", "none");
              self.removeClassName("reply-form-container__no-subject");
            }
          }, 2000
        );
      }
    } else {
      self.close();
      headerDiv.setHtml(initialHeader)
        .removeClassName("message-sent");
      to.setVisible(true);
      subject.setVisible(true);
      text.setVisible(true);
      send.setVisible(true);
    }
    if (subject.getText().length() > 0) {
      to.setText("");
      subject.setText("");
      text.setText("");
    }
  }
}