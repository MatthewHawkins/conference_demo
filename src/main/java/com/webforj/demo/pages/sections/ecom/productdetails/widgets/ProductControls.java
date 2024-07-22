package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import java.util.ArrayList;

import com.webforj.App;
import com.webforj.component.Component;
import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;

public class ProductControls extends Div {
    
  public ProductControls() {
    ChoiceBox sizeDrop = new ChoiceBox();

    ArrayList<ListItem> sizeCategories = new ArrayList<>();
    sizeCategories.add(new ListItem("XS"));
    sizeCategories.add(new ListItem("S"));
    sizeCategories.add(new ListItem("M"));
    sizeCategories.add(new ListItem("L"));
    sizeCategories.add(new ListItem("XL"));

    sizeDrop.insert(sizeCategories)
      .setLabel("Size")
      .selectIndex(0);

    ChoiceBox quantityDrop = new ChoiceBox();

    ArrayList<ListItem> quantityCategories = new ArrayList<>();
    quantityCategories.add(new ListItem("1"));
    quantityCategories.add(new ListItem("2"));
    quantityCategories.add(new ListItem("3"));
    quantityCategories.add(new ListItem("4"));
    quantityCategories.add(new ListItem("5"));

    quantityDrop.insert(quantityCategories)
      .setLabel("Quantity")
      .selectIndex(0);

    Div menuButtons = new Div();
    Div optionButtons = new Div();

    String heartIconHtml = "<html><dwc-icon name='heart' expanse='s'></dwc-icon></html>";
    String heartFilledIconHtml = "<html><dwc-icon name='heart-filled' expanse='s'></dwc-icon></html>";
    Button likeButton = new Button(heartIconHtml)
      .addClassName("like-button");

    likeButton.addClickListener(e -> {
      String currentButtonText = likeButton.getText();
      String newButtonText = currentButtonText.equals(heartIconHtml) ? heartFilledIconHtml : heartIconHtml;
      likeButton.setText(newButtonText);
    });


    Button cartButton = new Button("Add To Cart")
      .addClassName("add-to-cart-button");

    menuButtons.add(sizeDrop, quantityDrop);
    optionButtons.add(likeButton, cartButton);
    menuButtons.addClassName("controls-container__buttons-container");
    optionButtons.addClassName("controls-container__buttons-container");

    this.add(menuButtons, optionButtons);
    this.addClassName("controls-container");
  }
}
