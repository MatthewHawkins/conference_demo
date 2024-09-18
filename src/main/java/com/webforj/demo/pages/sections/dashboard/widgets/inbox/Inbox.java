package com.webforj.demo.pages.sections.dashboard.widgets.inbox;

import com.webforj.component.element.event.ElementClickEvent;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;


public class Inbox extends Div {

  Reply reply = new Reply();

  public Inbox() {
    Div card = new Div();
    card.addClassName("card card--inbox");

    Paragraph header = new Paragraph("Inbox")
      .addClassName("card__header");  

    Div messagesWrapper = new Div()
      .addClassName("card__messagesWrapper");

    add(card);

    String[] names = {
      "Nina Marti",
      "Dragan  Somma",
      "Gwyn Lundgren",
      "Luisa  Rojas",
      "Miguel  Pinto",
      "Paschalis Babineaux"
    };

    String[] messages = {
      "I've sent you the files for the...",
      "This UI looks awesome! Can you...",
      "Can you share the PSD file for...",
      "Can we schedule a call this...",
      "One of the simplest ways to...",
      "Hey! I attached some new..."
    };

    for (int i = 0; i < 6; i++) {
      Div message = new Div();
      message.setUserData("title", names[i])
      .setUserData("message", messages[i]);
      message.addClassName("card__message")
        .onClick(this::handleMessageClick);

      Div avatar = new Div();
      avatar.addClassName("card__messageAvatar");
      int rnd = (int) (Math.random() * 100);
      avatar.setHtml("<img alt='" + names[i] + "'' src='https://ui-avatars.com/api/?i=" + rnd
        + "&&background=random&&name=" + names[i]
        + "' />");
      message.add(avatar);

      Div wrapper = new Div();
      wrapper.addClassName("card__messageWrapper");

      Strong name = new Strong(i > 2 ? names[i] : names[i] + " (2)");
      name.addClassName("card__messageName");
      wrapper.add(name);

      Paragraph content = new Paragraph(messages[i]);
      content.addClassName("card__messageContent");
      wrapper.add(content);

      message.add(wrapper);
      messagesWrapper.add(message);
    }

    card.add(header, messagesWrapper);
  }

  private void handleMessageClick(ElementClickEvent event) {
    Div message = (Div) event.getComponent();
    String title = (String) message.getUserData("title");
    String messageText = (String) message.getUserData("message");
    
    if (!this.hasComponent(reply)) {
      add(reply);
    }
    reply.show(title, messageText);
  }

}