package com.webforj.demo.pages.sections.ecom.products.widgets;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Img;

public class ItemCard extends Composite<Div> {
  private Div imageDiv = new Div();
  private Div nameDiv = new Div();
  private Div priceDiv = new Div();
  private Div ratingDiv = new Div();
  private Div stockDiv = new Div();

  public ItemCard(String productName, Img productImage, String price, String rating, String stock) {
    imageDiv.addClassName("item-card__image");
    nameDiv.addClassName("item-card__name");
    priceDiv.addClassName("item-card__price");
    ratingDiv.addClassName("item-card__rating");
    stockDiv.addClassName("item-card__stock");

    this.nameDiv.setText(productName);
    this.priceDiv.setText(price);
    this.ratingDiv.setText(rating);
    this.stockDiv.setText("Stock: " + stock);

    imageDiv.add(productImage);
    imageDiv.setStyle("background-color", "var(--dwc-surface-1)");

    getBoundComponent().addClassName("item-card")
      .add(imageDiv, nameDiv, priceDiv, ratingDiv, stockDiv);
  }

}
