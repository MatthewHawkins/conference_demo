package com.webforj.demo.pages.sections.dashboard.widgets.teamcards;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;

public class TeamCardDisplay extends Composite<Div> {
  
  TeamCardWrapper teamCardWrapper = new TeamCardWrapper();

  public TeamCardDisplay() {
    String[] names = {
      "Telma Fridley",
      "Chandler Hervieux",
      "Percy Demers",
      "Antoine Masson"
    };

    String[] positions = {
      "Admin User",
      "Manager",
      "Director",
      "Premium User"
    };

    teamCardWrapper.addClassName("teamcard__wrapper");
    getBoundComponent().add(teamCardWrapper);

    for (int i = 0; i < names.length; i++) {
      TeamCard teamCard = new TeamCard();
      teamCard.setAvatar("https://coderthemes.com/ubold/layouts/default/assets/images/users/user-" + (i + 1) +".jpg");
      teamCard.setUserName(names[i]);
      teamCard.setPosition(positions[i]);
      teamCardWrapper.addTeamCard(teamCard);
    }
  }
    
}
