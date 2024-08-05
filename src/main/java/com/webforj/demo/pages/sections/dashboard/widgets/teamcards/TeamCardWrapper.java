package com.webforj.demo.pages.sections.dashboard.widgets.teamcards;

import java.util.ArrayList;

import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Span;
import com.webforj.component.html.elements.Strong;

public class TeamCardWrapper extends Div implements CardClickListener {
  ArrayList<TeamCard> teamCards = new ArrayList<>();

  public void onCardClicked(TeamCard card) {
    updateActiveCard(card);
    openContactInfo(card);
  }

  public void openContactInfo(TeamCard card) {
    Dialog dialog = new Dialog();
    Img img = new Img(card.getAvatar().getSrc(), "Avatar");
    img.addClassName("team__avatar");

    Span exit = new Span()
      .addClassName("button__team-card-close")
      .setHtml("<dwc-icon name='x'></dwc-icon>");
    exit.onClick(event -> {dialog.close();});

    Strong name = new Strong();
    name.addClassName("team__username")
      .setText(card.getUserName().getText());
    Paragraph position = new Paragraph();
    position.addClassName("team__position")
      .setText(card.getPosition().getText());


    dialog.addClassName("contact--info")
      .add(img, exit, name, position);
      dialog.setBlurred(true);

    add(dialog);
    dialog.open();
  }

  public void updateActiveCard(TeamCard activeCard) {
    for (TeamCard card : teamCards) {
      card.setActive(card.equals(activeCard));
    }
  }

  public void addTeamCard(TeamCard card) {
    card.setClickListener(this);
    teamCards.add(card);
    this.add(card);
  }
    
}
