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
    imageDiv.addClassName("image");
    nameDiv.addClassName("name");
    priceDiv.addClassName("price");
    ratingDiv.addClassName("rating");
    stockDiv.addClassName("stock");

    this.nameDiv.setText(productName);
    this.priceDiv.setText(price);
    this.ratingDiv.setText(rating);
    this.stockDiv.setText("Stock: " + stock);

    imageDiv.add(productImage);
    imageDiv.setStyle("background-color", "var(--dwc-surface-1)");

    getBoundComponent().addClassName("itemcard")
      .add(imageDiv, nameDiv, priceDiv, ratingDiv, stockDiv);
  }

}
