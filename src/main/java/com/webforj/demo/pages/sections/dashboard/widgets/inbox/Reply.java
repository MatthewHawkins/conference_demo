package com.webforj.demo.pages.sections.dashboard.widgets.inbox;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.field.TextField;
import com.webforj.component.html.elements.Div;
import com.webforj.component.textarea.TextArea;
import com.webforj.component.button.event.ButtonClickEvent;

import static com.webforj.component.button.ButtonTheme.PRIMARY;

public class Reply extends Composite<Dialog> {

  Dialog self = getBoundComponent();
  TextField to = new TextField();
  TextField subject = new TextField();
  TextArea text = new TextArea();

  public Reply() {
    self.addToHeader(new Div().setHtml("<dwc-icon name='send'></dwc-icon> Reply To Message"));
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

    Button send = new Button("Send");
    send.setTheme(PRIMARY);
    send.onClick(this::handleButtonClick);
  
    Button cancel = new Button("Cancel");
    cancel.onClick(this::handleButtonClick);
  
    self.addToFooter(send, cancel);
  }

  /**
   * Show the dialog.
   */
  public void show(String to, String text) {
    this.to.setText(to);
    this.text.setText("> " + text + "\n");
    self.open();
  }

  private void handleButtonClick(ButtonClickEvent event) {
    self.close();
    to.setText("");
    subject.setText("");
    text.setText("");
  }
}