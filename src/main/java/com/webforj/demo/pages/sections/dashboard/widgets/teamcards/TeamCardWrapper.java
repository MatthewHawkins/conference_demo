package com.webforj.demo.pages.sections.dashboard.widgets.teamcards;

import java.util.ArrayList;

import com.webforj.component.button.Button;
import com.webforj.component.dialog.Dialog;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
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
    img.addClassName("team--avatar");
    // Button exit = new Button("<html><dwc-icon name='square-letter-x'></dwc-icon></html>")
    //   .addClassName("button__team-card-close");
    // dialog.addToHeader(img, exit);
    Strong name = new Strong();
    name.addClassName("team--username")
      .setText(card.getUserName().getText());
    Paragraph position = new Paragraph();
    position.addClassName("team--position")
      .setText(card.getPosition().getText());


    dialog.addClassName("contact--info")
      .add(img, name, position);

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
