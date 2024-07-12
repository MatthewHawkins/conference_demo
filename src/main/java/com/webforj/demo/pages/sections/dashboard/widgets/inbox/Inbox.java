package com.webforj.demo.pages.sections.dashboard.widgets.inbox;

import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;
import com.webforj.component.html.event.HtmlClickEvent;


public class Inbox extends Div {
    Reply reply = new Reply();

    public Inbox() {
        Div card = new Div();
        card.addClassName("card card--inbox");

        Paragraph header = new Paragraph();
        header.addClassName("card_header")
            .setText("Inbox");

        Div messagesWrapper = new Div();
        messagesWrapper.addClassName("card_messagesWrapper");

        add(card);

        String[] names = {
            "Nina Martí",
            "Dragan Somma",
            "Gwyn Lundgren",
            "Luisa Mäkelä",
            "Miguel Pinto",
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
            message.addClassName("card_message")
                .setUserData("title", names[i])
                .setUserData("message", messages[i]);
            message.onClick(this::handleMessageClick);

            Div avatar = new Div();
            avatar.addClassName("card_messageAvatar");
            int rnd = (int) (Math.random() *  100);
            avatar.setHtml("<img alt='" + names[i] + "'' src='https://ui-avatars.com/api/?i='" + rnd + "&&background=random&&name=" + names[i] + "' />");
            message.add(avatar);

            Div wrapper = new Div();
            wrapper.addClassName("card_messageWrapper");

            Strong name = new Strong();
            name.addClassName("card_messageName");
            name.setText(i > 2 ? names[i] : names[i] + " (2)");
            wrapper.add(name);

            Paragraph content = new Paragraph();
            content.addClassName("card_messageContent")
                .setText(messages[i]);
            wrapper.add(content);

            message.add(wrapper);
            messagesWrapper.add(message);
        }

        card.add(header, messagesWrapper);
    }

    private void handleMessageClick(HtmlClickEvent event) {
        Div message = (Div) event.getComponent();
        String title = (String) message.getUserData("title");
        String messageText = (String) message.getUserData("message");

        add(reply);
        reply.show(title, messageText);

    }
    
}
