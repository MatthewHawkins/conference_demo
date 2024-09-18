package com.webforj.demo.pages.sections.ecom.productdetails.widgets;

import java.util.ArrayList;

import com.webforj.component.button.Button;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Span;
import com.webforj.component.list.ChoiceBox;
import com.webforj.component.list.ListItem;
import com.webforj.demo.pages.sections.ecom.checkout.widgets.Rating;

public class ProductControls extends Div {
    
  public ProductControls() {
    ChoiceBox sizeDrop = new ChoiceBox();
    Rating rating = new Rating();
    Div ratingDiv = new Div();

    Span header = new Span("Rate this product");
    rating.setPrecision(.5);
    ratingDiv.add(header, rating);
    ratingDiv.addClassName("sl-component__rating");

    

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
    Div ratingButtons = new Div();

    Button cartButton = new Button("Add To Cart")
      .addClassName("button__add-to-cart");

    menuButtons.add(sizeDrop, quantityDrop, cartButton);
    ratingButtons.add(ratingDiv);
    menuButtons.addClassName("controls-container__buttons-container");
    ratingButtons.addClassName("controls-container__rating-buttons-container");

    this.add(menuButtons, ratingButtons);
    this.addClassName("controls-container");
  }
}
