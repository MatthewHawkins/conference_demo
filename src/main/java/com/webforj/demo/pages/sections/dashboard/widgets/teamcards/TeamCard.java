package com.webforj.demo.pages.sections.dashboard.widgets.teamcards;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.component.html.elements.Strong;

public class TeamCard extends Composite<Div> {
  Img avatar = new Img();
  Strong username = new Strong();
  Paragraph position = new Paragraph();

  private CardClickListener clickListener;

  public TeamCard() {
    avatar.addClassName("team--avatar");
    username.addClassName("team--username");
    position.addClassName("team--position");

    getBoundComponent().addClassName("team--card");
    getBoundComponent().add(avatar);

    Div textWrapper = new Div();
    getBoundComponent().add(textWrapper);
    textWrapper.add(username, position);

    listenForCardClicked();
  }

  public void setActive(boolean isActive) {
    if (isActive) {
      getBoundComponent().addClassName("is-active");
    } else {
      getBoundComponent().removeClassName("is-active");
    }
  }

  public void listenForCardClicked() {
    getBoundComponent().addClickListener(event -> {
      if (clickListener != null) {
        clickListener.onCardClicked(this);
      }
    });
  }

  public void setClickListener(CardClickListener listener) {
    this.clickListener = listener;
  }

  public Img getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar.setSrc(avatar);
  }

  public Strong getUserName() {
    return this.username;
  }

  public void setUserName(String name) {
    this.username.setText(name);
  }

  public Paragraph getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position.setText(position);
  }
  
}
    

